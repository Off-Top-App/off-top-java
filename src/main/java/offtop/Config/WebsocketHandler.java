package offtop.Config;

// import java.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.time.LocalDateTime;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import offtop.Models.AudioEvent;
import offtop.Services.WebsocketService;

@Component
public class WebsocketHandler <T> extends TextWebSocketHandler {

    @Autowired
    private WebsocketService websocketService;

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    Map <Double,WebSocketSession> userSessions = new ConcurrentHashMap<Double,WebSocketSession>();
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        for (int i = 0; i < sessions.size(); i++) {
            WebSocketSession webSocketSession; //= (WebSocketSession) sessions.get(i);
            
            Map <String, T> value = new Gson().fromJson(message.getPayload(), Map.class);
            double userId = (double)value.get("user_id");
            LocalDateTime timeStamp = LocalDateTime.now();
            String topic = value.get("topic").toString();
            String audioData = value.get("audio_data").toString();
            System.out.println("id type: " + value.get("user_id").getClass());
            AudioEvent audioEvent = new AudioEvent(audioData,userId,timeStamp.toString(),topic);
           
            //if the user connects to the websocket for the first time
            if(!userSessions.containsKey(userId)){
                userSessions.put(userId,session);
            }
            webSocketSession = userSessions.get(userId);
          
            websocketService.handleIncomingMessages((ArrayList<Double>)value.get("audio_data"), audioEvent);
            TextMessage textMessage = new TextMessage("Received " + audioEvent.getAudioData()+ " !");
            webSocketSession.sendMessage(textMessage);
        }
    }


    public void sendConsumerData(double userId,String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        //Makes sure the user is connected to websocket
        if(userSessions.containsKey(userId)){
            userSessions.get(userId).sendMessage(textMessage);
        }
    
    }

    @Override
    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
        session.setTextMessageSizeLimit(1024 * 1024);
        session.setBinaryMessageSizeLimit(1024 * 1024);
        System.out.println("CREATED SESSION: " + session.toString());
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("CLOSED CONNECTION: " + status);
        super.afterConnectionClosed(session, status);
    }

}

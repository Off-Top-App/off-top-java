package offtop.Config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

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
public class WebsocketHandler extends TextWebSocketHandler {


    @Autowired
    private WebsocketService websocketService;

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        for (int i = 0; i < sessions.size(); i++) {
            WebSocketSession webSocketSession = (WebSocketSession) sessions.get(i);

            Map<String,String> value = new Gson().fromJson(message.getPayload(), Map.class);

            String file = value.get("file");
            int userId =Integer.parseInt( value.get("userId"));
            LocalDateTime timeStamp = LocalDateTime.parse(value.get("timestamp"));

            AudioEvent audioEvent = new AudioEvent(file,userId,timeStamp);
            
            handleMessages(audioEvent);
            TextMessage textMessage = new TextMessage("Received " + audioEvent.getFile()+ " !");
            webSocketSession.sendMessage(textMessage);
        }
    }
    @Override
	public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
        System.out.println("CREATED SESSION: " + session.toString());
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("CLOSED CONNECTION");
        super.afterConnectionClosed(session, status);
    }

    public void handleMessages(AudioEvent data){
        websocketService.sendFileEvent(data);
    }
    
}
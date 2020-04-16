package offtop.Config;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

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
            AudioEvent value = new Gson().fromJson(message.getPayload(), AudioEvent.class);
            handleMessages(value);
            TextMessage textMessage = new TextMessage("Received " + value.getFile()+ " !");
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
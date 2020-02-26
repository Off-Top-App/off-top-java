package offtop.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

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
            Map value = new Gson().fromJson(message.getPayload(), Map.class);
            handleMessages(value);
            TextMessage textMessage = new TextMessage("Received " + value.get("message") + " !");
            webSocketSession.sendMessage(textMessage);
        }
    }

	@Override
	public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
        System.out.println("sessions: " + session.toString());
        sessions.add(session);
    }

    public void handleMessages(Map data){
        Stream<String> s = Stream.of(data.values().toString());
        s.forEach(val -> {
            websocketService.logData(val);
        });    
    }
    
}
package offtop.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/websocket");             // allow us to connect to ws://localhost:8080/websocket with the default Spring port configuration.
        registry.addEndpoint("/sockjs").withSockJS();   // allows a client which does not support WebSocket natively mimic a WebSocket over an HTTP connection
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){  //The configureMessageBroker method sets up a simple (in-memory) message broker for our application
       registry.enableSimpleBroker("/topic");                   //topic to be routed back to client
       registry.setApplicationDestinationPrefixes("/app");      //This configuration allows Spring to understand that any message sent to a WebSocket channel name prefixed with /app should be routed to a @MessageMapping in our application.
    }
}
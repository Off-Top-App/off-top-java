package offtop.Services;

import com.google.gson.Gson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import offtop.Config.WebsocketHandler;

import java.util.Map;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private WebsocketHandler handler;

    public Consumer(WebsocketHandler handler) {
        this.handler = handler;
    }

    // Receives message from the producer and displays into console
    // KafkaListner suscribes to a topic and receives all the message sent into that
    // topic
    @KafkaListener(topics = "outgoingFocusScore", groupId = "group_Id")
    public void receiveFocusScore(String message) {
        message = message.substring(1, message.length() - 1);
        String _message = message.replaceAll("\\\\\"", "\"");
        System.out.println("_message: " + _message);
        Map value = new Gson().fromJson(_message, Map.class);
        logger.info(String.format("The message you entered -> %s", value.toString()));
        double userId = (double) value.get("user_id");
        try {
            logger.info(String.format("The message you entered -> %s", value.toString()));
            handler.sendConsumerData(userId, _message);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

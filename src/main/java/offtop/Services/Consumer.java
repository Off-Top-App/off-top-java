package offtop.Services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
   
    //Receives message from the producer and displays into console
    //KafkaListner suscribes to a topic and receives all the message sent into that topic
    @KafkaListener(topics = "Computers",groupId = "group_Id")
    public void receive(String message) throws IOException{
        logger.info(String.format("The message you entered -> %s", message));
    }  
}




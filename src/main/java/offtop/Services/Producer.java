package offtop.Services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

   private static final Logger logger = LoggerFactory.getLogger(Producer.class);
   private static final String TOPIC = "Computers";

   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

   // produces and sends message by topic
   public void sendMessage(String message) {
      logger.info(String.format(" Producing message -> %s", message));
      kafkaTemplate.send(TOPIC, message);
   }

}
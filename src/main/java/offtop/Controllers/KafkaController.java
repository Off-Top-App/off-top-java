package offtop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import offtop.Services.Producer;


@RestController
@RequestMapping(value ="/kafka")
public class KafkaController{

    private final Producer producer;

    //Set up bean for KafkaController 
    @Autowired
    KafkaController(Producer producer){
        this.producer = producer;
    }

    //Publish the messages sent from producer to consumer
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
    
}
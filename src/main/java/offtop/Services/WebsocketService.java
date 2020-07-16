package offtop.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import offtop.Models.AudioEvent;

@Service
public class WebsocketService {

  // @Autowired
  // AudioService audioService;
    @Autowired
    ProducerService producerService;

  public void handleIncomingMessages(AudioEvent data){
    
    producerService.produceToAudioTransformation(data);
  }
}
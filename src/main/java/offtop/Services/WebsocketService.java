package offtop.Services;

import org.springframework.stereotype.Service;

import offtop.Models.AudioEvent;

@Service
public class WebsocketService{



    private final Producer producer;

  public WebsocketService(Producer producer) {
    this.producer = producer;
  }
    public void logData(String val){
        System.out.println("Data Received from Flutter: " + val);
    }
    public void sendFileEvent(AudioEvent audioEvent){
      producer.sendAudioFile(audioEvent);
      }
}
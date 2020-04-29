package offtop.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import offtop.Models.AudioEvent;

@Service
public class WebsocketService {

  @Autowired
  AudioService audioService;

  public void handleIncomingMessages(ArrayList<Double> audioData, AudioEvent data){
    audioService.converToByteDataAndProduceMessage(audioData, data);
  }
}
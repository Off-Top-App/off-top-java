package offtop.Services;

// import java.io.ByteArrayOutputStream;
// import java.util.Base64;
// import java.nio.charset.StandardCharsets;
// import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.stereotype.Service;

import offtop.Models.AudioEvent;

@Service
public class WebsocketService {

  private final Producer producer;

  public WebsocketService(Producer producer) {
    this.producer = producer;
  }

  public void writeToAudioFile(ArrayList<Double> audioData) {
    byte[] byteArray = new byte[1024];

    Iterator<Double> iterator = audioData.iterator();

    System.out.println(byteArray);

    while (iterator.hasNext()) {
      Integer i = iterator.next().intValue();
      byteArray[i] = i.byteValue();
    }
    // NOTE: the following try-catch will attempt to create the audio file
    // try {
    // File someFile = new File("AudioFile.mp3");
    // FileOutputStream fos = new FileOutputStream(someFile);
    // fos.write(byteArray);
    // fos.flush();
    // fos.close();

    // System.out.println("File created");
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println("Error: " + e);
    // }
  }

  public void sendFileEvent(AudioEvent audioEvent) {
    producer.sendAudioFile(audioEvent);
  }
}
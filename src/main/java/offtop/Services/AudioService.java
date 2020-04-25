package offtop.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import offtop.Models.AudioEvent;

@Service
public class AudioService{

    @Autowired
    Producer producer;

    //only being used when wanting to write files
    public void writeBytesToFile(List<Double> audioData){
        try {
            File someFile = new File("AudioFile.wav");
            FileOutputStream fos = new FileOutputStream(someFile);
            fos.write(writeToBytes(audioData));
            fos.flush();
            fos.close();
            System.out.println("File created");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    byte[] writeToBytes(List<Double> audioData) {
        byte[] result = new byte[audioData.size()];
        for (int i = 0; i < audioData.size(); i++) {
            result[i] = audioData.get(i).byteValue();
        }
        return result;  
    }
    public void converToByteDataAndProduceMessage(ArrayList<Double> audioData, AudioEvent originalAudioEvent ) {
        byte[] audioBytes = writeToBytes(audioData);
        AudioEvent audioEvent = new AudioEvent(
          java.util.Arrays.toString(audioBytes), 
          originalAudioEvent.getUserId(), 
          originalAudioEvent.getTimeStamp(), 
          originalAudioEvent.getTopic()
        );
        sendAudioEvent(audioEvent);
    }


    public void sendAudioEvent(AudioEvent audioEvent) {
        producer.sendAudioFile(audioEvent);
    }
}
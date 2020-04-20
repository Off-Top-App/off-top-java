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

@Service
public class WebsocketService {

    // here we will send data to kafka
    public void logData(ArrayList<Double> val) {
        byte[] byteArray = new byte[1024];

        Iterator<Double> iterator = val.iterator();

        System.out.println(byteArray);

        while (iterator.hasNext()) {
            Integer i = iterator.next().intValue();
            byteArray[i] = i.byteValue();
        }

        // NOTE: the following print should be a list
        // eg [112.0, 161.0, 245.0, 2.0, 175.0, 117.0, 35.0...]
        System.out.println("Data Received from Flutter: " + val);

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
}
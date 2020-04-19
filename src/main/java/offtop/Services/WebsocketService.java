package offtop.Services;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.io.File;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;

@Service
public class WebsocketService {

    // here we will send data to kafka
    public void logData(ArrayList<Double> val) {
        // System.out.println(val);

        byte[] byteArray = new byte[1024];

        Iterator<Double> iterator = val.iterator();

        System.out.println(byteArray);
        while (iterator.hasNext()) {
            Integer i = iterator.next().intValue();
            byteArray[i] = i.byteValue();
        }

        System.out.println("Data Received from Flutter: " + val.get(0));

        try {
            File someFile = new File("anotherOne.mp3");
            FileOutputStream fos = new FileOutputStream(someFile);
            fos.write(byteArray);
            fos.flush();
            fos.close();

            System.out.println("just so we know we made it");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("oopsie poopsie!");
        }

        // String base64Image = val.split(",")[1];

        // byte[] decoded = Base64.getDecoder().decode("something", 0);
        // Utilities.log("~~~~~~~~ Decoded: ", Arrays.toString(decoded));
        //

        // byte[] decodedBytes = Base64.getMimeDecoder().decode(val);
        // // String decodedString = new String(decodedBytes);

        // System.out.println("TEST---------TEST---------TEST---------TEST---------TEST---------:"
        // + decodedString);

        // String s = new String(decodedBytes, StandardCharsets.UTF_8);
        // System.out.println("Output : " + s);
    }
}
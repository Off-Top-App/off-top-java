package offtop.Services;

// import java.io.ByteArrayOutputStream;
// import java.util.Base64;
// import java.nio.charset.StandardCharsets;
// import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.ByteArrayInputStream;
import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

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
    try {
			// File outputFile = File.createTempFile("MediaFile", "aac", getCacheDir());
      File someFile = new File("AudioFile.aac");
      FileOutputStream fos = new FileOutputStream(someFile);
      fos.write(byteArray);
      fos.flush();
      fos.close();

      System.out.println("File created");
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Error: " + e);
    }


	//Note that input file type does not depend
    // on file name or extension.
    // File inputFileObj = new File(args[0]);
    // AudioInputStream audioInputStream = null;
    // try{
    //   audioInputStream = AudioSystem.
    //            getAudioInputStream(inputFileObj);
    // }catch (Exception e){
    //   e.printStackTrace();
    //   System.exit(0);
    // }//end catch

    // System.out.println("Input file format:");
    // showFileType(inputFileObj);

    // int bytesWritten = 0;
    // try{
    //   bytesWritten = AudioSystem.
    //                     write(audioInputStream,
    //                           outputType,
    //                           new File(args[1]));
    // }catch (Exception e){
    //   e.printStackTrace();
	//   System.exit(0)
	  
    // try {
    //   File someFile = new File("test.wav");
	// 	AudioInputStream audioStream = AudioSystem.getAudioInputStream(someFile);
	// 	if (someFile.getName().endsWith("wav")) {
	// 		int nb = AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE,
	// 	new FileOutputStream(someFile));
	// System.out.println("file written");
	// 		// log.fine("WAV file written to " + someFile.getCanonicalPath()
	// 		// 		+ " (" + (nb / 1000) + " kB)");
	// 	}
	// 	else {
	// 		throw new RuntimeException("Unsupported encoding " + someFile);
	// 	}
	// }
	// catch (Exception e) {
	// 	e.printStackTrace();
	// 	throw new RuntimeException("could not generate file: " + e);
	// }
  }

  public void sendFileEvent(AudioEvent audioEvent) {
    producer.sendAudioFile(audioEvent);
  }
}
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
  private static byte[] addWavHeader(byte[] bytes) throws IOException {

		ByteBuffer bufferWithHeader = ByteBuffer.allocate(bytes.length + 44);
		bufferWithHeader.order(ByteOrder.LITTLE_ENDIAN);
		bufferWithHeader.put("RIFF".getBytes());
		bufferWithHeader.putInt(bytes.length + 36);
		bufferWithHeader.put("WAVE".getBytes());
		bufferWithHeader.put("fmt ".getBytes());
		bufferWithHeader.putInt(16);
		bufferWithHeader.putShort((short) 1);
		bufferWithHeader.putShort((short) 1);
		bufferWithHeader.putInt(16000);
		bufferWithHeader.putInt(32000);
		bufferWithHeader.putShort((short) 2);
		bufferWithHeader.putShort((short) 16);
		bufferWithHeader.put("data".getBytes());
		bufferWithHeader.putInt(bytes.length);
		bufferWithHeader.put(bytes);
		return bufferWithHeader.array();
	}

  public static AudioInputStream getAudioStream(byte[] byteArray) {
		try {
			try {
				ByteArrayInputStream byteStream =
						new ByteArrayInputStream(byteArray);
				return AudioSystem.getAudioInputStream(byteStream);
			}
			catch (UnsupportedAudioFileException e) {
				byteArray = addWavHeader(byteArray);
				ByteArrayInputStream byteStream =
						new ByteArrayInputStream(byteArray);
				return AudioSystem.getAudioInputStream(byteStream);
			}
		}
		catch (IOException | UnsupportedAudioFileException e) {
			throw new RuntimeException("cannot convert bytes to audio stream: " + e);
		}
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
    //   File someFile = new File("AudioFile.mp3");
    //   FileOutputStream fos = new FileOutputStream(someFile);
    //   fos.write(byteArray);
    //   fos.flush();
    //   fos.close();

    //   System.out.println("File created");
    // } catch (Exception e) {
    //   // TODO: handle exception
    //   System.out.println("Error: " + e);
    // }

    try {
      File someFile = new File("test.wav");
			AudioInputStream audioStream = getAudioStream(byteArray);
			if (someFile.getName().endsWith("wav")) {
				int nb = AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE,
            new FileOutputStream(someFile));
        System.out.println("file written");
				// log.fine("WAV file written to " + someFile.getCanonicalPath()
				// 		+ " (" + (nb / 1000) + " kB)");
			}
			else {
				throw new RuntimeException("Unsupported encoding " + someFile);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("could not generate file: " + e);
		}
  }

  public void sendFileEvent(AudioEvent audioEvent) {
    producer.sendAudioFile(audioEvent);
  }
}
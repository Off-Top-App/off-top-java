// package offtop.Services;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.nio.file.Files;
// import java.nio.file.Paths;

// import com.google.cloud.storage.Bucket;
// import com.google.cloud.storage.Storage;
// import com.google.cloud.storage.StorageOptions;
// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.cloud.storage.Blob;
// import com.google.common.collect.Lists;

// import org.springframework.stereotype.Service;

// import offtop.Models.AudioEvent;

// @Service
//  public class AudioFirebase {
//     final String projectID ="off-top-firebase";
//     final String bucketName ="off-top-firebase.appspot.com";
//     final String objectName ="wavFile #1";

//     public String postGCP(String filePath,AudioEvent AudioObject) throws IOException{
//         final String fileName =  AudioObject.getUserId() + "_"+ AudioObject.getTimeStamp() + ".wav";
//         Bucket bucket = validateGCPStorage("off-top-firebase.appspot.com");
//         InputStream inputStream = new FileInputStream(filePath);
        
//         Blob blob = bucket.create(fileName, inputStream, "audio/wav");
//         System.out.println("\nGot here. Uploading File");
//         return blob.getMediaLink();
//     }    
    
//     private Bucket validateGCPStorage(String bucketName) throws IOException {
//         GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("off-top-firebase-firebase-adminsdk-u5wol-20735648c8.json"))
//             .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//         Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//         Bucket bucket = storage.get(bucketName);
//         if (bucket == null) {
//         throw new IOException("Bucket not found:"+bucketName);
//         }
//         return bucket;
//     }

// }
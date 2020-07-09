package offtop.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.api.Page;
import com.google.api.services.storage.Storage;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import org.springframework.stereotype.Service;

@Service
public class AudioFirebase {
    final String projectID ="off-top-firebase";
    
    public void PostFirebase(File testFile) throws IOException {
        String filePath = testFile.getAbsolutePath();
        
        System.out.print(filePath);
        FirebaseOptions options;
    
        System.out.println("\n\n\nI am here");
        try {
            FileInputStream serviceAccount = new FileInputStream("/Users/deion/Downloads/off-top-firebase-firebase-adminsdk-u5wol-1ecb210468.json");

            options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("off-top-firebase.appspot.com")
                .build(); 
            FirebaseApp fireApp = FirebaseApp.initializeApp(options);
            

            StorageClient storageClient = StorageClient.getInstance(fireApp);
            InputStream uploadFile = new FileInputStream(filePath);
            String blobString = "NEW_FOLDER/" + "FILE_NAME.EXT"; 

            System.out.println("\n\n\nGotHERE\n\nFileUploading");

            storageClient.bucket().create(blobString, uploadFile , Bucket.BlobWriteOption.userProject(projectID));
            

        } catch (IOException e) {
            
            e.printStackTrace();
        }catch(OutOfMemoryError E){
            
            E.printStackTrace();
        }
    }

}
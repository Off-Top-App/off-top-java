package offtop.Services;

import org.springframework.stereotype.Service;

@Service
public class WebsocketService{

    // here we will send data to kafka
    public void logData(String val){
        System.out.println("Data Received from Flutter: " + val);
    }
}
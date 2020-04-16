package offtop.Models;

import java.time.LocalDateTime;

public class AudioEvent {
    private String file;
    private int userId;
    private LocalDateTime timeStamp;
         
    public AudioEvent(String file,int  userId, LocalDateTime timeStamp){
        this.file = file;
        this.userId = userId;
        this.timeStamp = timeStamp;
    }
    public String getFile() {
        return this.file;
    }
    public int getUserId() {
        return this.userId;
    }
    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }
}
package offtop.Models;

import java.time.LocalDateTime;

public class AudioEvent {
    private String file;
    private int userId;
    private String timeStamp;


    public AudioEvent(String file,int  userId, String timeStamp){
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
    public String getTimeStamp() {
        return this.timeStamp;
    }

    private AudioEvent(){
            
    }

    @Override
    public String toString() {
        return "Audio-Event{" +
            "file='" + file + '\'' +
            ", userId='" + userId + '\'' +
            ", timeStamp=" + timeStamp.toString() +
            '}';
    }
}
package offtop.Models;

import java.time.LocalDateTime;

public class AudioEvent {
    private String file;
    private int userId;
    private String timeStamp;
    private String topic;


    public AudioEvent(String file,int  userId, String timeStamp, String topic){
        this.file = file;
        this.userId = userId;
        this.timeStamp = timeStamp;
        this.topic = topic;
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
    public String getTopic() {
        return this.topic;
    }

    public AudioEvent(){
            
    }

    @Override
    public String toString() {
        return "Audio-Event{" +
            "file='" + file + '\'' +
            ", userId='" + userId + '\'' +
            ", timeStamp=" + timeStamp.toString() + '\''+
            ", topic = " + topic + '\''+
            '}';
    }
}
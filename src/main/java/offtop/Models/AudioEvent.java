package offtop.Models;

import java.time.LocalDateTime;

public class AudioEvent {
    private String audioData;
    private int userId;
    private String timeStamp;
    private String topic;


    public AudioEvent(String audioData,double userId, String timeStamp, String topic){
        this.audioData = audioData;
        this.userId = (int)Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
    }
    public String getAudioData() {
        return this.audioData;
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
            "audioData='" + audioData + '\'' +
            ", userId='" + userId + '\'' +
            ", timeStamp=" + timeStamp.toString() + '\''+
            ", topic = " + topic + '\''+
            '}';
    }
}
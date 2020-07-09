package offtop.Models;

import java.time.LocalDateTime;

public class AudioEvent {
    private String audioData;
    private int userId;
    private String timeStamp;
    private String topic;
    private String filePath;

    public AudioEvent() {}

    public AudioEvent(double userId, String timeStamp, String topic) {
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
        this.filePath = null;
    }

    public AudioEvent(String audioData, double userId, String timeStamp, String topic) {
        this.audioData = audioData;
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
        this.filePath = null;
    }

    public AudioEvent(double userId, String timeStamp, String topic,String filePath) {//constuctor with filepath
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
        this.filePath = filePath;
    }

    public AudioEvent(String audioData, double userId, String timeStamp, String topic,String filePath) {//constructor with filepath
        this.audioData = audioData;
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
        this.filePath = filePath;
    }
    public String getFilePath(){
        return this.filePath;
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

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    public void setAudioData(String audioData) {
        this.audioData = audioData;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
	public String toString() {
		return "AudioEvent [audioData=" + audioData + ", filePath=" + filePath + ", timeStamp=" + timeStamp + ", topic="
				+ topic + ", userId=" + userId + "]";
	}
}
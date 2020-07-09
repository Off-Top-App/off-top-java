package offtop.Models;

public class AudioBytesEvent {
    private String bytesData;
    private int userId;
    private String timeStamp;
    private String topic;

    public String getBytesData() {
        return bytesData;
    }

    public void setBytesData(String bytesData) {
        this.bytesData = bytesData;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "AudioBytesEvent [bytesData=" + bytesData + ", timeStamp=" + timeStamp + ", topic=" + topic + ", userId="
                + userId + "]";
    }
    public AudioBytesEvent(double userId, String timeStamp, String topic) {
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
    }

    public AudioBytesEvent(String bytesData, double userId2, String timeStamp, String topic) {
        this.bytesData = bytesData;
        this.userId = (int) Math.round(userId);
        this.timeStamp = timeStamp;
        this.topic = topic;
    }
   
}
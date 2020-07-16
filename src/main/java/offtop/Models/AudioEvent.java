package offtop.Models;

import java.util.List;

public class AudioEvent {
    private List<Double> audio_data;
    private int user_id;
    private String time_exported;
    private String topic;
    private String filePath;


    
    public AudioEvent(List<Double> audio_data, int user_id, String time_exported, String topic, String filePath) {
        this.audio_data = audio_data;
        this.user_id = user_id;
        this.time_exported = time_exported;
        this.topic = topic;
        this.filePath = filePath;
    }

    public AudioEvent(List<Double> audio_data, int userId, String time_exported, String topic) {
        this.audio_data = audio_data;
        this.user_id = userId;
        this.time_exported = time_exported;
        this.topic = topic;
    }

    public AudioEvent() {
    }

    public List<Double> getAudio_data() {
        return audio_data;
    }

    public void setAudio_data(List<Double> audio_data) {
        this.audio_data = audio_data;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTime_exported() {
        return time_exported;
    }

    public void setTime_exported(String time_exported) {
        this.time_exported = time_exported;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "AudioEvent [audio_data=" + audio_data + ", filePath=" + filePath + ", time_exported=" + time_exported
                + ", topic=" + topic + ", user_id=" + user_id + "]";
    }

    
}
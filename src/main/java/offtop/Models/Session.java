package offtop.Models;

public class Session{
    public int Id;
    public int audioFile;
    public String timeStart;
    public String timeEnd;
    public String focusScorePerMinute;
    public String heartRatePerMinute;
    public int overalScore;
    public int userId;
    public String createdAt;
    public String deletedAt;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(int audioFile) {
        this.audioFile = audioFile;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getFocusScorePerMinute() {
        return focusScorePerMinute;
    }

    public void setFocusScorePerMinute(String focusScorePerMinute) {
        this.focusScorePerMinute = focusScorePerMinute;
    }

    public String getHeartRatePerMinute() {
        return heartRatePerMinute;
    }

    public void setHeartRatePerMinute(String heartRatePerMinute) {
        this.heartRatePerMinute = heartRatePerMinute;
    }

    public int getOveralScore() {
        return overalScore;
    }

    public void setOveralScore(int overalScore) {
        this.overalScore = overalScore;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    
}
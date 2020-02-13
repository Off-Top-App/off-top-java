package offtop.Models;

public class Settings{
    public String defaultTopic;
    public String preset;
    public String colorTheme;
    public String alertVibration;
    public String alertFlash;
    public String alertSound;

    public String getDefaultTopic() {
        return defaultTopic;
    }

    public void setDefaultTopic(String defaultTopic) {
        this.defaultTopic = defaultTopic;
    }

    public String getPreset() {
        return preset;
    }

    public void setPreset(String preset) {
        this.preset = preset;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public String getAlertVibration() {
        return alertVibration;
    }

    public void setAlertVibration(String alertVibration) {
        this.alertVibration = alertVibration;
    }

    public String getAlertFlash() {
        return alertFlash;
    }

    public void setAlertFlash(String alertFlash) {
        this.alertFlash = alertFlash;
    }

    public String getAlertSound() {
        return alertSound;
    }

    public void setAlertSound(String alertSound) {
        this.alertSound = alertSound;
    }
   
}
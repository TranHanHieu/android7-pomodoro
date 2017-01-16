package com.example.hieuit.android7_pomodoro.settings;

/**
 * Created by Hieu It on 1/16/2017.
 */

public class SettingCredentials {
    private String workTime;
    private String breaks;
    private String longBreak;

    public SettingCredentials(String workTime, String breaks, String longBreak) {
        this.workTime = workTime;
        this.breaks = breaks;
        this.longBreak = longBreak;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getBreaks() {
        return breaks;
    }

    public void setBreaks(String breaks) {
        this.breaks = breaks;
    }

    public String getLongBreak() {
        return longBreak;
    }

    public void setLongBreak(String longBreak) {
        this.longBreak = longBreak;
    }
}

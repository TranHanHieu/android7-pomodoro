package com.example.hieuit.android7_pomodoro.databases.models;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class ColorTask {
    private String color;

    public ColorTask(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorTask{" +
                "color='" + color + '\'' +
                '}';
    }
}

package com.example.hieuit.android7_pomodoro.databases.models;

/**
 * Created by Hieu It on 2/15/2017.
 */

public class TaskColor {
    private String color;
    private boolean isCheck;

    public TaskColor(String color, boolean isCheck) {
        this.color = color;
        this.isCheck = isCheck;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public TaskColor(String color) {
        this.color = color;
    }

    public static String[] COLORS = new String[] {
            "#0091EA",
            "#00C853",
            "#FFD600",
            "#DD2C00",
            "#AA00FF",
            "#757575",
            "#F50057"
    };

    @Override
    public String toString() {
        return "TaskColor{" +
                "color='" + color + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}

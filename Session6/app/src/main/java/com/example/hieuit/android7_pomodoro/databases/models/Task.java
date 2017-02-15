package com.example.hieuit.android7_pomodoro.databases.models;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class Task {
    private String name;
    private String color;

    public Task(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

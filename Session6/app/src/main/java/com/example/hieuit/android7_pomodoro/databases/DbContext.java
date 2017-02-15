package com.example.hieuit.android7_pomodoro.databases;

import com.example.hieuit.android7_pomodoro.databases.models.Color;
import com.example.hieuit.android7_pomodoro.databases.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class DbContext {

    public static final DbContext instance = new DbContext();

    public List<Task> allTasks(){
        //Fake data (dummy data)
        //1 create aray list
        ArrayList<Task > tasks = new ArrayList<>();
        //2. add some task and return
        tasks.add((new Task("study recycelView","#EF5350")));
        tasks.add((new Task("Practice recycelView","#8E24AA")));
        tasks.add((new Task("Practice netwroking","#3949AB")));
        tasks.add((new Task("Party End - Lectures","#26C6DA")));
        tasks.add((new Task("study API","#D4E157")));
        return tasks;
    }

    public List<Color> allColors(){
        //1 create aray list
        ArrayList<Color > colorTasks = new ArrayList<>();
        //2. add some task and return
        colorTasks.add((new Color("#EF5350")));
        colorTasks.add((new Color("#8E24AA")));
        colorTasks.add((new Color("#3949AB")));
        colorTasks.add((new Color("#26C6DA")));
        colorTasks.add((new Color("#D4E157")));
        colorTasks.add((new Color("#2196F3")));
        colorTasks.add((new Color("#03A9F4")));
        colorTasks.add((new Color("#009688")));
        return colorTasks;
    }
}

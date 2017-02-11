package com.example.hieuit.android7_pomodoro.databases;

import com.example.hieuit.android7_pomodoro.databases.models.ColorTask;
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

    public List<ColorTask> allColors(){
        //1 create aray list
        ArrayList<ColorTask > colorTasks = new ArrayList<>();
        //2. add some task and return
        colorTasks.add((new ColorTask("#EF5350")));
        colorTasks.add((new ColorTask("#8E24AA")));
        colorTasks.add((new ColorTask("#3949AB")));
        colorTasks.add((new ColorTask("#26C6DA")));
        colorTasks.add((new ColorTask("#D4E157")));
        return colorTasks;
    }
    public static String[] colors={"#F44336","#E91E63","#9C27B0","#673AB7",
            "#3F51B5","#2196F3","#03A9F4","#009688"};
}

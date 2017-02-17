package com.example.hieuit.android7_pomodoro.databases;

import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.databases.models.TaskColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class DbContext {

    public static final DbContext instance = new DbContext();
    private ArrayList<Task > tasks;

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> allTasks(){
        //Fake data (dummy data)
        //1 create aray list
        if (tasks == null) {
            tasks = new ArrayList<>();
            //2. add some task and return
            tasks.add((new Task("Study recycelView", TaskColor.COLORS[0],2.3f)));
            tasks.add((new Task("Practice recycelView", TaskColor.COLORS[1],1.2f)));
            tasks.add((new Task("Practice netwroking", TaskColor.COLORS[2],0.5f)));
            tasks.add((new Task("Party End - Lectures", "#26C6DA",2.4f)));
            tasks.add((new Task("Study API", "#D4E157",1.4f)));
        }
        return tasks;
    }

//    public List<TaskColor> allColors(){
//        //1 create aray list
//        ArrayList<TaskColor > colorTasks = new ArrayList<>();
//        //2. add some task and return
//        colorTasks.add((new TaskColor("#EF5350")));
//        colorTasks.add((new TaskColor("#8E24AA")));
//        colorTasks.add((new TaskColor("#3949AB")));
//        colorTasks.add((new TaskColor("#26C6DA")));
//        colorTasks.add((new TaskColor("#D4E157")));
//        colorTasks.add((new TaskColor("#2196F3")));
//        colorTasks.add((new TaskColor("#03A9F4")));
//        colorTasks.add((new TaskColor("#009688")));
//        return colorTasks;
//    }
    public void addTask(Task newTask){
        tasks.add(newTask);
    }
}

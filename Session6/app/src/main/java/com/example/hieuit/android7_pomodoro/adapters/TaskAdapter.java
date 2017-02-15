package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskViewHolder;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>{
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1.create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task,parent,false);

        //2 create viewholder
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        return taskViewHolder;

    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {

        //1. get data bases on position
        Task task = DbContext.instance.allTasks().get(position);
        //2.  Bind data into view
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTasks().size();
    }
}

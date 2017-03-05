package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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


    public interface TaskItemClickListenner{
        void onItemClick(Task task);
    }

    public interface TaskTimerListenner{
        void onStart(Task task);
    }

    public interface TaskLongClickListener{
        void taskLongClick(Task task);
    }

    private TaskItemClickListenner taskItemClickListenner;
    private TaskTimerListenner taskTimerListenner;
    private TaskLongClickListener taskLongClickListener;

    public void setTaskLongClickListener(TaskLongClickListener taskLongClickListener) {
        this.taskLongClickListener = taskLongClickListener;
    }

    public void setTaskTimerListenner(TaskTimerListenner taskTimerListenner) {
        this.taskTimerListenner = taskTimerListenner;
    }

    public void setTaskItemClickListenner(TaskItemClickListenner taskItemClickListenner) {
        this.taskItemClickListenner = taskItemClickListenner;
    }

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
    public void onBindViewHolder(TaskViewHolder holder, final int position) {

        //1. get data bases on position
        final Task task = DbContext.instance.allTasks().get(position);
        //2.  Bind data into view
        holder.bind(task);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send event to outside
                if (taskItemClickListenner !=null){
                    taskItemClickListenner.onItemClick(task);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (taskLongClickListener!=null){
                    taskLongClickListener.taskLongClick(task);
                }
                return false;
            }
        });

        holder.ibStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (taskTimerListenner !=null){
                    taskTimerListenner.onStart(task);
                }
            }
        });

        holder.vTaskColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.flipDone();
                TaskAdapter.this.notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTasks().size();
    }
}

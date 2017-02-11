package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.databases.models.Task;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.v_task_color)
    View vTaskColor;

    @BindView(R.id.tv_task_name)
    TextView tvTaskName;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public  void bind(Task task){
        //1 bind color
        vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
        //2 bind Task name
        tvTaskName.setText(task.getName());
    }
}
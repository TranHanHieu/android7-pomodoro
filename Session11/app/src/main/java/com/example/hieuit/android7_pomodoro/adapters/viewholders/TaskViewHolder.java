package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private static final String DEFAULT = "#FFFF";
    @BindView(R.id.v_task_color)
    public View vTaskColor;

    @BindView(R.id.tv_task_name)
    public TextView tvTaskName;

    @BindView(R.id.ib_startTimer)
    public ImageButton ibStartTimer;

    @BindView(R.id.iv_check1)
    ImageView ivCheck;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Task task) {
        //1 bind color
//        vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
//        GradientDrawable gradientDrawable = (GradientDrawable) vTaskColor.getBackground();
//        gradientDrawable.setColor(Color.parseColor(task.getColor()));
        //2 bind Task name
        if (task.getColor()!=null) {
            Utils.setSolidColor(vTaskColor, task.getColor());
        }else {
            Utils.setSolidColor(vTaskColor,DEFAULT);
        }
        tvTaskName.setText(task.getName());
        if (task.isDone()){
            ivCheck.setVisibility(View.VISIBLE);
        }else {
            ivCheck.setVisibility(View.INVISIBLE);
        }
    }
}

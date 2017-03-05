package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.databases.models.TaskColor;
import com.example.hieuit.android7_pomodoro.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hieu It on 2/15/2017.
 */

public class TaskColorHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.v_color_task)
    View vTaskColor;
    @BindView(R.id.iv_check)
    ImageView ivCheck;


    public TaskColorHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(String color) {
        //1 bind color
//        vTaskColor.setBackgroundColor(Color.parseColor(task.getColor()));
//        GradientDrawable gradientDrawable = (GradientDrawable) vTaskColor.getBackground();
//        gradientDrawable.setColor(Color.parseColor(color.getColor()));
        //2 bind Task name
        Utils.setSolidColor(vTaskColor,color);

    }

    public void setCheck(boolean check){
        if (check){
            ivCheck.setVisibility(View.VISIBLE);
        }else {
            ivCheck.setVisibility(View.INVISIBLE);
        }
    }
}

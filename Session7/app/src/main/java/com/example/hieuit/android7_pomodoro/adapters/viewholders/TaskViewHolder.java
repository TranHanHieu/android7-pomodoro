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
import butterknife.OnClick;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class TaskViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.v_task_color)
    View vTaskColor;

    @BindView(R.id.tv_task_name)
    TextView tvTaskName;

    @BindView(R.id.ib_timer)
    ImageButton ibTimer;

    @BindView(R.id.iv_choose)
    ImageView ivChoose;

    public ImageButton getIbTimer() {
        return ibTimer;
    }

    public ImageView getIvChoose() {
        return ivChoose;
    }

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
        Utils.setSolidColor(vTaskColor, task.getColor());
        tvTaskName.setText(task.getName());
        if (task.isCheck()) {
            ivChoose.setVisibility(View.VISIBLE);
        } else {
            ivChoose.setVisibility(View.INVISIBLE);
        }
    }

    public void setChoose(boolean choose) {
        if (choose) {
            ivChoose.setVisibility(View.VISIBLE);
        } else {
            ivChoose.setVisibility(View.INVISIBLE);
        }
    }
}

package com.example.hieuit.android7_pomodoro.adapters.viewholders;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.databases.models.ColorTask;

import butterknife.BindBool;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class ColorViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.v_color_task)
    View vColor;
    @BindView(R.id.cb_color_task)
    CheckBox cbColor;

    public ColorViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(String color){
        GradientDrawable drawable= (GradientDrawable) vColor.getBackground();
        drawable.setColor(Color.parseColor(color));
    }
}

package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskColorHolder;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskViewHolder;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.TaskColor;

/**
 * Created by Hieu It on 2/15/2017.
 */

public class TaskColorAdapter extends RecyclerView.Adapter<TaskColorHolder> {

    private int selectionPosition;

    public String getSelectedColor() {
        return TaskColor.COLORS[selectionPosition];
    }

    public void setSelectedColor(String color) {
        selectionPosition = 0;
        for (int colorIndex = 0; colorIndex < TaskColor.COLORS.length; colorIndex++) {
            if (TaskColor.COLORS[colorIndex].equalsIgnoreCase(color)) {
                selectionPosition = colorIndex;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public TaskColorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1.create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_color, parent, false);

        //2 create viewholder
        TaskColorHolder colorViewHolder = new TaskColorHolder(itemView);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskColorHolder holder, final int position) {
        String color = TaskColor.COLORS[position];
        holder.bind(color);

        if (selectionPosition == position) {
            //display check
            holder.setCheck(true);
        } else {
            holder.setCheck(false);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectionPosition = position;
                notifyDataSetChanged(); //hàm vẽ lại hết(gọi oncreate....

            }
        });
    }

    @Override
    public int getItemCount() {
        return TaskColor.COLORS.length;
    }
}

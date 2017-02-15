package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskColorHolder;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskViewHolder;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Color;

/**
 * Created by Hieu It on 2/15/2017.
 */

    public class ColorAdapter extends RecyclerView.Adapter<TaskColorHolder> {
        @Override
        public TaskColorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //1.create View
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View itemView = layoutInflater.inflate(R.layout.item_color,parent,false);

            //2 create viewholder
            TaskColorHolder colorViewHolder = new TaskColorHolder(itemView);
            return colorViewHolder;
        }

        @Override
        public void onBindViewHolder(TaskColorHolder holder, int position) {
            Color color = DbContext.instance.allColors().get(position);
            holder.bind(color);
        }

        @Override
        public int getItemCount() {
            return DbContext.instance.allColors().size();
        }
    }

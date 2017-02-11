package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.ColorViewHolder;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.ColorTask;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1.create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_color,parent,false);

        //2 create viewholder
        ColorViewHolder colorViewHolder = new ColorViewHolder(itemView);
        return colorViewHolder;
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        String colorTask = DbContext.colors[position];
        holder.bind(colorTask);
    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allColors().size();
    }
}

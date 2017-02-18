package com.example.hieuit.android7_pomodoro.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.adapters.viewholders.TaskViewHolder;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.databases.models.TaskColor;
import com.example.hieuit.android7_pomodoro.fragrment.TimerFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Hieu It on 2/11/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private static final String TAG = TaskAdapter.class.toString();

    public interface TaskItemClickListenner {
        void onItemClick(Task task);
    }

    public interface ImageButtonClickListenner {
        void onClick();
    }


    private TaskItemClickListenner taskItemClickListenner;
    private ImageButtonClickListenner imageButtonClickListenner;

    public void setImageButtonClickListenner(ImageButtonClickListenner imageButtonClickListenner) {
        this.imageButtonClickListenner = imageButtonClickListenner;
    }

    public void setTaskItemClickListenner(TaskItemClickListenner taskItemClickListenner) {
        this.taskItemClickListenner = taskItemClickListenner;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1.create View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_task, parent, false);

        //2 create viewholder
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        return taskViewHolder;
    }


    @Override
    public void onBindViewHolder(final TaskViewHolder holder, final int position) {

        //1. get data bases on position
        final Task task = DbContext.instance.allTasks().get(position);
        //2.  Bind data into view
        holder.bind(task);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG,String.format( "onClick: %s",position));
                //send event to outside
                if (taskItemClickListenner != null) {
                    taskItemClickListenner.onItemClick(task);
                }
            }
        });
        holder.getIbTimer().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageButtonClickListenner != null) {
                    imageButtonClickListenner.onClick();
                }
            }
        });
        holder.getvTaskColor().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!task.isCheck()) {
                    holder.setChoose(true);
                    task.setCheck(true);
                }else {
                    holder.setChoose(false);
                    task.setCheck(false);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return DbContext.instance.allTasks().size();
    }
}

package com.example.hieuit.android7_pomodoro.fragrment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.activitys.TaskActivity;
import com.example.hieuit.android7_pomodoro.adapters.TaskAdapter;
import com.example.hieuit.android7_pomodoro.adapters.TaskColorAdapter;
import com.example.hieuit.android7_pomodoro.databases.DbContext;
import com.example.hieuit.android7_pomodoro.databases.models.Task;
import com.example.hieuit.android7_pomodoro.decorations.TaskColorDecoration;
import com.example.hieuit.android7_pomodoro.fragrment.strategies.TaskAction;
import com.example.hieuit.android7_pomodoro.networks.NetContext;
import com.example.hieuit.android7_pomodoro.networks.services.AddTask;
import com.example.hieuit.android7_pomodoro.settings.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {

    @BindView(R.id.rv_color)
    RecyclerView rv_color;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_payment)
    EditText etPayment;

    private TaskColorAdapter colorAdapter;
    private String title;
    private Task task;
    private TaskAction taskAction;

    public TaskDetailFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    public void setTaskAction(TaskAction taskAction) {
        this.taskAction = taskAction;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);
        setupUI(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);
        colorAdapter = new TaskColorAdapter();
        rv_color.setAdapter(colorAdapter);
        rv_color.addItemDecoration(new TaskColorDecoration());
        rv_color.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv_color.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        if (getActivity() instanceof TaskActivity) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
        if (task != null) {
            //lấy data trc khi edit
            etName.setText(task.getName());
            etPayment.setText(String.format("%.1f", task.getPaymentPerHour()));
            colorAdapter.setSelectedColor(task.getColor());
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mn_ok) {
            //1.get data UI
            String taskName = etName.getText().toString();
            float paymentPerHour=0;
            String color = colorAdapter.getSelectedColor();
            try {
                paymentPerHour = Float.parseFloat(etPayment.getText().toString());
            } catch (NumberFormatException e) {
                String[] str = etPayment.getText().toString().split(",");
                paymentPerHour = (Float.parseFloat(str[0] + "." + str[1]));
            }
            //2.create new task

            if (task == null) {
                //add
                task = new Task(taskName, color, paymentPerHour);
                //1.create retrofit
                //2.create service
                AddTask addTaskService = NetContext.instance.getRetrofit().create(AddTask.class);
                Call<Task> addTask = addTaskService.addTask("application/json", "JWT " + SharedPrefs.getInstance().getAccessToken(), task);
                addTask.enqueue(new Callback<Task>() {
                    @Override
                    public void onResponse(Call<Task> call, Response<Task> response) {
                        Log.d(TaskDetailFragment.class.toString(), "onResponse: " + response.body().toString());
                        taskAction.excute(task);
                    }

                    @Override
                    public void onFailure(Call<Task> call, Throwable t) {

                    }
                });
//                //data to Json
//                MediaType jsonType = MediaType.parse("application/json");
//                String taskJson = (new Gson().toJson(new Task(task.getName(),task.getColor(),task.getPaymentPerHour())));
//                RequestBody taskBoy = RequestBody.create(jsonType,taskJson);
                //3.call
            } else {
                //edit
                task.setName(taskName);
                task.setColor(color);
                task.setPaymentPerHour(paymentPerHour);
                taskAction.excute(task);
            }
            getActivity().onBackPressed();

        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_edit_task, menu);
        menu.removeItem(R.id.action_settings);
    }
}

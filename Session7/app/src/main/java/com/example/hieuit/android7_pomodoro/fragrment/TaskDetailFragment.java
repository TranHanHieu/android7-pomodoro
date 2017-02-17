package com.example.hieuit.android7_pomodoro.fragrment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public TaskDetailFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
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
            //edit
            etName.setText(task.getName());
            etPayment.setText(String.format("%.1f", task.getPaymentPerHour()));
            colorAdapter.setSelectedColor(task.getColor());
        }
    }

    public interface MenuItemListenner {
        void onClick(MenuItem item);
    }

    class MenuItemOnClick implements MenuItemListenner {

        @Override
        public void onClick(MenuItem item) {

            //1.get data UI
            String taskName = etName.getText().toString();
            float paymentPerHour = Float.parseFloat(etPayment.getText().toString());
            String color = colorAdapter.getSelectedColor();

            if (title.equals(getString(R.string.edit_task))) {
                //2.edit task
                task.setName(taskName);
                task.setPaymentPerHour(paymentPerHour);
                task.setColor(color);
            } else {
                //2.create new task
                Task newTask = new Task(taskName, color, paymentPerHour);

                //3.add to database
                DbContext.instance.addTask(newTask);
            }
            getActivity().onBackPressed();


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItemOnClick menuItemOnClick = new MenuItemOnClick();
        if (item.getItemId() == R.id.mn_ok) {
            menuItemOnClick.onClick(item);
        }

        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_edit_task, menu);
        menu.removeItem(R.id.action_settings);
    }
}

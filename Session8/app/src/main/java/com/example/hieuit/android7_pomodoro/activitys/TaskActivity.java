package com.example.hieuit.android7_pomodoro.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hieuit.android7_pomodoro.R;
import com.example.hieuit.android7_pomodoro.fragrment.FragmentListenner;
import com.example.hieuit.android7_pomodoro.fragrment.TaskFragment;

import butterknife.ButterKnife;

public class TaskActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,FragmentListenner {

    private static final String TAG = TaskActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        // TODO: Move UI setup to proper method
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount()>0){
                    toggle.setDrawerIndicatorEnabled(false);//ẩn toggle
                    toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24px);
                    toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onBackPressed();
                        }
                    });
                }else {
                    toggle.setDrawerIndicatorEnabled(true);
                    toggle.setToolbarNavigationClickListener(null);
                }
            }
        });




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        //1
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        //2
//        TaskFragment taskFragment = new TaskFragment();
//        //3
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//báo fragment sắp chuyển
//        fragmentTransaction.replace(R.id.fl_main,taskFragment);
//        fragmentTransaction.commit();
        replaceFragment(new TaskFragment(),false);

        ButterKnife.bind(this);

//        setupUI();
    }

//    private void setupUI() {
//        ButterKnife.bind(this);
//
//        taskAdapter = new TaskAdapter();
//        rvTask.setAdapter(taskAdapter);
//        rvTask.setLayoutManager(new LinearLayoutManager(this));
//        getSupportActionBar().setTitle(R.string.tasks);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        rvTask.addItemDecoration(dividerItemDecoration);
//
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @OnClick(R.id.fab)
//    void onFabClick(){
//        TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
//
//        (TaskActivity)getA
//    }

    @Override
    public void replaceFragment(Fragment fragment,boolean addToBackstack){
        if (addToBackstack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main, fragment)
                    .addToBackStack(null)
                    .commit();
        }else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_main, fragment)
                    .commit();
        }
    }
}
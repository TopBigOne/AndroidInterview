package com.android.interview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.interview.R;
import com.android.interview.activity.life.ALifeActivity;
import com.android.interview.event.OnTouchActivity;
import com.android.interview.utils.Nav;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnEvent;
    private Button btnActivityLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        initToolBar();
        initView();
        initEvent();

        initFloatingActionButton();

    }

    private void initEvent() {
        btnEvent.setOnClickListener(this);
        btnActivityLife.setOnClickListener(this);
    }


    private void initView() {
        btnEvent = findViewById(R.id.btn_dispatch_event);
        btnActivityLife = findViewById(R.id.btn_activity_life);
    }

    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_dispatch_event:
                Nav.goActivity(this, OnTouchActivity.class);
                break;

            case R.id.btn_activity_life:
                Nav.goActivity(this, ALifeActivity.class);
                break;


        }

    }
}

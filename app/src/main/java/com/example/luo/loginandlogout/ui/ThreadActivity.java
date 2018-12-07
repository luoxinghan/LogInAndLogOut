package com.example.luo.loginandlogout.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luo.loginandlogout.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TAG = "MyLogs";
    private Button mThreadButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        mThreadButton = findViewById(R.id.thread_button);
        mThreadButton.setOnClickListener(this);
        Log.d(TAG, "onCreate: " + Thread.currentThread().getName());
    }

    private void hardWorkThread(Handler handler) {
        long time = 2000L;
        try {
            Thread.sleep(time);
            Log.d(TAG, "onCreate: " + Thread.currentThread().getName());
            final String name = Thread.currentThread().getName();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    mThreadButton.setText(name);
                }
            });
            //Toast.makeText(getBaseContext(), "Sleep over", Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.thread_button:
                final Handler handler = new Handler();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        hardWorkThread(handler);
                    }
                });
                thread.start();
                break;
        }
    }
}

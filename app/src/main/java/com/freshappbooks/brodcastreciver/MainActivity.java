package com.freshappbooks.brodcastreciver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    // create service
    // add task
    // add reciever

public class MainActivity extends AppCompatActivity {

    private Button buttonStartService;
    private Button buttonStopService;
    private Button buttonSentBroadcast;
    private SimpleReceiver receiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartService = findViewById(R.id.button_start_service);
        buttonStopService = findViewById(R.id.button_stop_service);
        buttonSentBroadcast = findViewById(R.id.button_sent_broadcast);

        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        receiver = new SimpleReceiver();
        filter = new IntentFilter(SimpleReceiver.SIMPLE_ACTION);

        buttonSentBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(SimpleReceiver.SIMPLE_ACTION));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}

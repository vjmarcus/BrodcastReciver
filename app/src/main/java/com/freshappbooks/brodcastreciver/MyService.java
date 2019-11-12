package com.freshappbooks.brodcastreciver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    public static final String TAG  = "MyApp";
    public static final String TIME = "TIME";
    private ScheduledExecutorService service;

    public MyService() {
    }

    @Override  // for bind services
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG , "onCreate work");
        service = Executors.newScheduledThreadPool(1);  // create, run in onStartCommand
    }

    @Override
    public void onDestroy() {
        Log.d(TAG , "onDestroy work");
        service.shutdown();

    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.d(TAG , "onStartCommand work");
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + System.currentTimeMillis());
                Intent intentToSent = new Intent(SimpleReceiver.SIMPLE_ACTION);
                intentToSent.putExtra(TIME, System.currentTimeMillis());
                sendBroadcast(intentToSent);

            }
        }, 1000, 4000, TimeUnit.MILLISECONDS);
        return START_STICKY; // if service was shutdown by system - system try to restart it.
    }
}

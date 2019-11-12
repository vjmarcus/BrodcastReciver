package com.freshappbooks.brodcastreciver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG  = "MyApp";
    public MyService() {
    }

    @Override  // for bind services
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.v(TAG , "onCreate work");
    }

    @Override
    public void onDestroy() {
        Log.v(TAG , "onDestroy work");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG , "onStartCommand work");

        return START_STICKY; // if service was shutdown by system - system try to restart it.
    }
}

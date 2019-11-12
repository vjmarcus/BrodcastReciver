package com.freshappbooks.brodcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SimpleReceiver extends BroadcastReceiver {

    public static final String SIMPLE_ACTION = "com.freshappbooks.brodcastreciver.SIMPLE_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {  // run in main Thread
        Toast.makeText(context, "CATCH = " + intent.getLongExtra(MyService.TIME, 0L), Toast.LENGTH_SHORT).show();
    }
}

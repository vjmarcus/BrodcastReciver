package com.freshappbooks.brodcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SimpleReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {  // run in main Thread
        Toast.makeText(context, "CATCH = " + intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}

package com.example.tnua_hadasha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastBattery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int battery = intent.getIntExtra("level",98);
        Toast.makeText(context,"סוללה נמוכה"+String.valueOf(battery),Toast.LENGTH_SHORT).show();

    }
}

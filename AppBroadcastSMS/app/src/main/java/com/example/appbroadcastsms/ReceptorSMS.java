package com.example.appbroadcastsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceptorSMS extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())){

            Toast.makeText(context, "Has recibido un nuevo SMS", Toast.LENGTH_SHORT).show();
            Log.d("SmsReceiver", "Se ha recibido un nuevo SMS.");

        }
    }
}

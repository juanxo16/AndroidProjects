package com.example.appbroadcastavion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceptorAvion extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())){

            //Verificar el estado del modo avion
            boolean siModoAvionActivo = intent.getBooleanExtra("state", false);
            String mensaje = siModoAvionActivo ? "Modo avion activado" : "Modo avion desactivado";

            //mostramos el mensaje
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
            Log.println(Log.INFO, "ReceptorAvion", mensaje);

        }
    }
}

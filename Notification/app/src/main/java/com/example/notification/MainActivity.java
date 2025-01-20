package com.example.notification;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private Button boton;
    private static final String CHANNEL_ID = "id de mi canal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        createNotificationChannel();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] eventos = new String[5];
        inboxStyle.setBigContentTitle("Notificación expandible:"); // Título
        eventos[0] = "Esta es la primera línea";
        eventos[1] = "Esta es la segunda línea";
        eventos[2] = "Esta es la tercera línea";
        eventos[3] = "Esta es la cuarta línea";
        eventos[4] = "Esta es la quinta línea";

// Mueve eventos dentro del expanded layout
        for (int i = 0; i < eventos.length; i++) {
            inboxStyle.addLine(eventos[i]);
        }

// Construir la notificación
        NotificationCompat.Builder notifica = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_notifications_24) // Icono de la notificación
                .setContentTitle("Mi notificación") // Título
                .setContentText("Has recibido una notificación") // Mensaje
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Prioridad
                .setContentIntent(pendingIntent) // Acción al hacer clic
                .setStyle(inboxStyle) // Mueve el expanded layout a la notificación
                .setWhen(0) // Ponerlo en la cima de las notificaciones
                .setPriority(NotificationCompat.PRIORITY_MAX) // Dar máxima prioridad
                .setAutoCancel(true); // Cerrar la notificación al hacer clic

        boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(1, notifica.build());
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }




    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this.
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
package com.example.mediconline;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import android.os.Build;



public class formulario_registro extends AppCompatActivity {
    private final static  String CANAL_1_ID = "canal1";
    private final static  String CANAL_1_NOMBRE = "Canal 1";
    private final static  String CANAL_1_DESCRIPCION = "Este es el Canal 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crearCanalesNotificaciones();
        setContentView(R.layout.activity_formulario_registro);
    }
    //insertarpaciente
     public void insertarpaciente(View v) {
        addNotification();
    }
    public void crearCanalesNotificaciones(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel canal1= new NotificationChannel(CANAL_1_ID, CANAL_1_NOMBRE, NotificationManager.IMPORTANCE_HIGH);
            canal1.setDescription(CANAL_1_DESCRIPCION);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canal1);
        }
    }



    private void addNotification() {
//        Notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CANAL_1_ID);
        builder.setSmallIcon(R.drawable.ic_kit_de_primeros_auxilios).setContentTitle("Se ha registrado con exito").setContentText("Revise su correo electronico en los proximos 2 dias").setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);






        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(1,builder.build());


    }
}
package com.example.jugandoconalarmas_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int CODIGO_ALARMA = 100;
    Button buttonActivar, buttonCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonActivar = findViewById(R.id.buttonActivar);
        buttonCancelar = findViewById(R.id.buttonCancelar);

        buttonActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), Alarma.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), 1000*30, pendingIntent);
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getApplicationContext(), Alarma.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), CODIGO_ALARMA,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.cancel(pendingIntent);
            }
        });
    }
}
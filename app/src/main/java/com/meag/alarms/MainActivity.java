package com.meag.alarms;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button setBtn;
        setBtn = (Button) findViewById(R.id.setalarm);
        setBtn.setOnClickListener(new View.OnClickListener() {
            EditText hor = (EditText) findViewById(R.id.horas);
            EditText minu = (EditText) findViewById(R.id.minutos);
            Integer hora = (Integer) Integer.parseInt(hor.getText().toString());
            Integer minuto = (Integer) Integer.parseInt(minu.getText().toString());

            @Override
            public void onClick(View v) {
                setalarm("Alarm has been set", 9 , 30);
            }
        });
    }

    public void setalarm(String mensaje, int horas, int minutos) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
                .putExtra(AlarmClock.EXTRA_HOUR, horas)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutos);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

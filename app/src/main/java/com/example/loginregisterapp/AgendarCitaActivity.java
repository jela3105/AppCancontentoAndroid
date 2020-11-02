package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AgendarCitaActivity extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nombreMascota = extras.getString("nombreMascota");
            titulo = (TextView) findViewById(R.id.titulo_agendar_cita);
            titulo.setText("AGENDAR CITA PARA " + nombreMascota.toUpperCase());
        }

    }
}
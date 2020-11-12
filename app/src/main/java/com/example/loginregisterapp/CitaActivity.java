package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class CitaActivity extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            switch (Objects.requireNonNull(extras.getString("Accion"))) {
                case "Editar":

                    break;
                case "VerMas":

                    break;
                case "Agendar":

                    break;
            }
        }

    }
}
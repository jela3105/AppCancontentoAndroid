package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MascotaActivity extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);
        titulo = findViewById(R.id.titulo_mascota);

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            switch (Objects.requireNonNull(extras.getString("Action"))){
                case "Edit":
                    titulo.setText("EDITAR MASCOTA");
                    break;
                case "Add":
                    titulo.setText("AGREGAR MASCOTA");
                    break;
            }
        }
    }
}
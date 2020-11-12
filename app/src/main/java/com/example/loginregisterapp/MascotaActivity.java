package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            switch (extras.getString("Accion")){
                case "Editar":
                    break;
                case "Agregar":
                    break;
            }
        }
    }
}
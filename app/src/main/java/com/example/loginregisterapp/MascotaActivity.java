package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class MascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            switch (Objects.requireNonNull(extras.getString("Action"))){
                case "Edit":
                    break;
                case "Add":
                    break;
            }
        }
    }
}
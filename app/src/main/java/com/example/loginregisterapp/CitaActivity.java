package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregisterapp.Pickers.DatePickerFragment;

import java.util.Objects;

public class CitaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView titulo;
    EditText fechaCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        fechaCita = (EditText) findViewById(R.id.cita_datepicker);
        titulo = findViewById(R.id.titulo_cita);
        fechaCita.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            switch (Objects.requireNonNull(extras.getString("Action"))) {
                case "Edit":
                    titulo.setText("EDITAR CITA");
                    break;
                case "SeeMore":
                    titulo.setText("DETALLE CITA");
                    break;
                case "AgendarCitaServicio":
                    titulo.setText("AGENDAR CITA");
                    break;

                case "AgendarCitaMascota":
                    titulo.setText("AGENDAR CITA");
                    break;
            }
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.cita_datepicker):
                showDatePickerDialog();
                break;
        }
    }

    //https://programacionymas.com/blog/como-pedir-fecha-android-usando-date-picker
    private void showDatePickerDialog() {
        Toast.makeText(this, "entro en mostrar", Toast.LENGTH_SHORT).show();
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                String selectedDate = day + " / " + (month+1) + " / " + year;
                fechaCita.setText("caca");
            }
        });
        Toast.makeText(this, "salio de mostrar", Toast.LENGTH_SHORT).show();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
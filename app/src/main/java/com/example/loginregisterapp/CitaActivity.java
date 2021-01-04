package com.example.loginregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginregisterapp.Pickers.DatePickerFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class CitaActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

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
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date picker");
                break;
        }
    }

    //https://programacionymas.com/blog/como-pedir-fecha-android-usando-date-picker


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
       Calendar calendar = Calendar.getInstance();
       calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String chosenDay = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        fechaCita.setText(chosenDay);
    }
}
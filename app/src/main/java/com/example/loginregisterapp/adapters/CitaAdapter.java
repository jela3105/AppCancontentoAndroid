package com.example.loginregisterapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Cita;

import java.util.ArrayList;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.CitaViewHolder> {

    public static class CitaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        TextView nombreServicio, nombreMascota, descripcionCita;
        ImageView fotoMascota, imagenStatus;

        public CitaViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            //encontramos por id en item_cita
            nombreMascota = (TextView) itemView.findViewById(R.id.nombre_cita_mascota);
            nombreServicio = (TextView) itemView.findViewById(R.id.nombre_cita_servicio);
            descripcionCita = (TextView) itemView.findViewById(R.id.descripcion_cita);
            fotoMascota = (ImageView) itemView.findViewById(R.id.foto_cita_mascota);
            imagenStatus = (ImageView) itemView.findViewById(R.id.status_cita);
        }

        public void setOnClickListeners() {
            //botones en item_cita
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }

    ArrayList<Cita> listaCita;

    public CitaAdapter(ArrayList<Cita> listaCita) {
        this.listaCita = listaCita;
    }

    @NonNull
    @Override
    public CitaAdapter.CitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, null, false);
        return new CitaAdapter.CitaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitaAdapter.CitaViewHolder holder, int position) {
        //setting text to componets


        //events
        holder.setOnClickListeners();
    }


    @Override
    public int getItemCount() {
        return listaCita.size();
    }
}
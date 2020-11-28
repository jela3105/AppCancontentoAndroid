package com.example.loginregisterapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.CitaActivity;
import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Servicio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ServiciosAdapter  extends RecyclerView.Adapter<ServiciosAdapter.ServiciosViewHolder>{

    public class ServiciosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Context context;
        TextView nombreServicio, descripcionServico;
        ImageButton buttonViewMore;
        ImageView fotoServicio;
        Button agendarCita;
        public ServiciosViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            nombreServicio = itemView.findViewById(R.id.nombre_servicio);
            buttonViewMore = itemView.findViewById(R.id.button_view_more_servicio);
            fotoServicio = itemView.findViewById(R.id.foto_servicio);
            descripcionServico = itemView.findViewById(R.id.descripcion_servicio);
            agendarCita =  itemView.findViewById(R.id.agendar_button_servicio);

        }

        public void setOnClickListeners(){
            agendarCita.setOnClickListener(this);
            buttonViewMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_view_more_servicio:
                    //call popup of to show servicio description
                    Toast.makeText(context, "Aqui debe de salir un popup", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.agendar_button_servicio:
                    Intent startAgendarCita = new Intent(context, CitaActivity.class);
                    startAgendarCita.putExtra("Action","AgendarCitaServicio");
                    context.startActivity(startAgendarCita);
                    break;
            }
        }


    }
    ArrayList<Servicio> listaServicios;

    public ServiciosAdapter(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    @NonNull
    @Override
    public ServiciosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicio,null,false);
        return new ServiciosAdapter.ServiciosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiciosViewHolder holder, int position) {
        holder.nombreServicio.setText(listaServicios.get(position).getNombre());
        holder.descripcionServico.setText(listaServicios.get(position).getDescripcion());
        Picasso.with(holder.context).load(listaServicios.get(position).getFoto()).into(holder.fotoServicio);
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return listaServicios.size();
    }


}

package com.example.loginregisterapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.CitaActivity;
import com.example.loginregisterapp.MascotaActivity;
import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    public static class  MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        TextView nombreMascota, descripcionMascota;
        ImageView fotoMascota;
        Button editarMascota, agendarCita;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            nombreMascota = (TextView) itemView.findViewById(R.id.nombreMascota);
            descripcionMascota = (TextView) itemView.findViewById(R.id.descripcionMascota);
            fotoMascota = (ImageView) itemView.findViewById(R.id.fotoMascota);
            editarMascota = (Button) itemView.findViewById(R.id.editar_button_mascota);
            agendarCita = (Button) itemView.findViewById(R.id.agendar_button_mascota);
        }

        public void setOnClickListeners(){
            editarMascota.setOnClickListener(this);
            agendarCita.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.agendar_button_mascota:
                    //Toast.makeText(view.getContext(), "agendarcita", Toast.LENGTH_SHORT).show();
                    Intent startAgendarCita = new Intent(context, CitaActivity.class);
                    startAgendarCita.putExtra("Accion","AgendarCitaMascota");
                    context.startActivity(startAgendarCita);
                    break;
                case  R.id.editar_button_mascota:
                    //Toast.makeText(view.getContext(), "editar mascota", Toast.LENGTH_SHORT).show();
                    Intent startEditarMascota = new Intent(context, MascotaActivity.class);
                    startEditarMascota.putExtra("Accion", "Editar");
                    context.startActivity(startEditarMascota);
                    break;

            }
        }
    }

    ArrayList<Mascota> listaMascota;

    public MascotaAdapter(ArrayList<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota,null,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        //setting text to componets
        holder.nombreMascota.setText(listaMascota.get(position).getNombre());
        holder.descripcionMascota.setText(listaMascota.get(position).getDescripcion());
        holder.fotoMascota.setImageResource(listaMascota.get(position).getFoto());

        //events
        holder.setOnClickListeners();
    }


    @Override
    public int getItemCount() {
        return listaMascota.size();
    }



}

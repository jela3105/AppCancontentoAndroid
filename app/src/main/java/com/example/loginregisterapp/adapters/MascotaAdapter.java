package com.example.loginregisterapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

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
        holder.nombreMascota.setText(listaMascota.get(position).getNombre());
        holder.descripcionMascota.setText(listaMascota.get(position).getDescripcion());
        holder.fotoMascota.setImageResource(listaMascota.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaMascota.size();
    }


    public class MascotaViewHolder extends RecyclerView.ViewHolder{

        TextView nombreMascota, descripcionMascota;
        ImageView fotoMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreMascota = (TextView) itemView.findViewById(R.id.nombreMascota);
            descripcionMascota = (TextView) itemView.findViewById(R.id.descripcionMascota);
            fotoMascota = (ImageView) itemView.findViewById(R.id.fotoMascota);
        }
    }
}

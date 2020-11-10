package com.example.loginregisterapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Servicio;

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
            setOnClickListeners();
            context = itemView.getContext();
            nombreServicio = (TextView) itemView.findViewById(R.id.nombre_servicio);
            buttonViewMore = (ImageButton) itemView.findViewById(R.id.button_view_more_servicio);
            fotoServicio = (ImageView) itemView.findViewById(R.id.foto_servicio);
            descripcionServico = (TextView) itemView.findViewById(R.id.descripcion_servicio);
            agendarCita = (Button) itemView.findViewById(R.id.agendar_button_servicio);
        }

        public void setOnClickListeners(){

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_view_more_servicio:
                    break;
                case R.id.agendar_button_servicio:
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
        holder.fotoServicio.setImageResource(listaServicios.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaServicios.size();
    }


}

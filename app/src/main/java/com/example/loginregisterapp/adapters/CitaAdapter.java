package com.example.loginregisterapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregisterapp.CitaActivity;
import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Cita;
import com.example.loginregisterapp.pojos.DescripcionCita;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.CitaViewHolder> {

    public static class CitaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Context context;
        TextView nombreServicio, nombreMascota, descripcionCita;
        ImageView fotoMascota, imagenStatus;
        ImageButton opciones;

        public CitaViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            //encontramos por id en item_cita
            nombreMascota = itemView.findViewById(R.id.nombre_cita_mascota);
            nombreServicio = itemView.findViewById(R.id.nombre_cita_servicio);
            descripcionCita = itemView.findViewById(R.id.descripcion_cita);
            fotoMascota = itemView.findViewById(R.id.foto_cita_mascota);
            imagenStatus = itemView.findViewById(R.id.status_cita);
            opciones = itemView.findViewById(R.id.button_more_cita);
        }

        public void setOnClickListeners() {
            opciones.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_more_cita:
                    PopupMenu popup = new PopupMenu(context, opciones);
                    popup.inflate(R.menu.options_cita_menu);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.ver_mas_cita:
                                    Intent startVerMasCita = new Intent(context, CitaActivity.class);
                                    startVerMasCita.putExtra("Action","SeeMore");
                                    context.startActivity(startVerMasCita);
                                    break;
                                case R.id.editar_menu_cita:
                                    Intent startEditarCita = new Intent(context, CitaActivity.class);
                                    startEditarCita.putExtra("Action","Edit");
                                    context.startActivity(startEditarCita);
                                    break;
                            }
                            return false;
                        }
                    });
                    //displaying the popup
                    popup.show();
                    break;
            }
        }
    }

    ArrayList<DescripcionCita> listaCita;

    public CitaAdapter(ArrayList<DescripcionCita> listaCita) {
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
        holder.nombreServicio.setText(listaCita.get(position).getServicio());
        holder.nombreMascota.setText(listaCita.get(position).getMascota());
        //holder.fotoMascota.setImageResource(listaCita.get(position).getFoto());
        Picasso.with(holder.context).load(listaCita.get(position).getFoto()).into(holder.fotoMascota);
        holder.descripcionCita.setText(listaCita.get(position).getDescripcion());

        switch (listaCita.get(position).getStatus()) {
            case 1:
                holder.imagenStatus.setImageResource(R.drawable.button_espera);
                break;
            case 2:
                holder.imagenStatus.setImageResource(R.drawable.button_confirmada);
                break;
            case 3:
                holder.imagenStatus.setImageResource(R.drawable.button_cancelada);
                break;
            case 4:
                holder.imagenStatus.setImageResource(R.drawable.button_finalizada);
                break;
        }
        //events
        holder.setOnClickListeners();

    }




    @Override
    public int getItemCount() {
        return listaCita.size();
    }
}

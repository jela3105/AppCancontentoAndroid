package com.example.loginregisterapp.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.CitaAdapter;
import com.example.loginregisterapp.adapters.MascotaAdapter;
import com.example.loginregisterapp.pojos.Cita;
import com.example.loginregisterapp.pojos.DescripcionCita;
import com.example.loginregisterapp.pojos.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CitasFragment extends Fragment {

    private View myFragment;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefreshLayoutCitas;
    private RecyclerView recyclerViewCitas;
    private ArrayList<DescripcionCita> listaCitas;

    public CitasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_citas, container, false);
        swipeRefreshLayoutCitas = myFragment.findViewById(R.id.recargar_citas);
        recyclerViewCitas =  myFragment.findViewById(R.id.recycler_citas);
        return myFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //actionFloatingButton
        fab = myFragment.findViewById(R.id.add_cita);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "hello citas", Toast.LENGTH_SHORT).show();
            }
        });

        //lista de mascotas
        listaCitas = new ArrayList<>();
        recyclerViewCitas.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        CitaAdapter citaAdapter = new CitaAdapter(listaCitas);
        recyclerViewCitas.setAdapter(citaAdapter);

        //recargar mascotas
        swipeRefreshLayoutCitas.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Se volvio a cargar citas", Toast.LENGTH_SHORT).show();
                swipeRefreshLayoutCitas.setRefreshing(false);
            }
        });
    }

    private void vaciarLista(){
        listaCitas.clear();
    }
    private void llenarLista() {

        DescripcionCita primero = new DescripcionCita();
        DescripcionCita segundo = new DescripcionCita();
        DescripcionCita tercero = new DescripcionCita();
        DescripcionCita cuarto = new DescripcionCita();

        primero.setFoto(R.drawable.primero);
        primero.setServicio("Corte de garras");
        primero.setStatus(1);
        primero.setMascota("El perrito");
        primero.setDescripcion("Se realiza un corte de garras muy chido");


        segundo.setFoto(R.drawable.elotrochico);
        segundo.setServicio("Baño especial");
        segundo.setStatus(2);
        segundo.setMascota("El segundo");
        segundo.setDescripcion("Se realiza un baño con shampoo");


        tercero.setFoto(R.drawable.picho);
        tercero.setServicio("Paseo");
        tercero.setStatus(3);
        tercero.setMascota("Picho");
        tercero.setDescripcion("Se realiza un paseo c");


        cuarto.setFoto(R.drawable.primero);
        cuarto.setServicio("Corte de garras");
        cuarto.setStatus(4);
        cuarto.setMascota("El perrito");
        cuarto.setDescripcion("Se realiza un corte de garras muy chido");


        listaCitas.add(primero);
        listaCitas.add(segundo);
        listaCitas.add(tercero);
        listaCitas.add(cuarto);

    }

}
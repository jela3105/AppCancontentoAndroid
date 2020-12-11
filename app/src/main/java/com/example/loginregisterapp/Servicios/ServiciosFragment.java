package com.example.loginregisterapp.Servicios;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.MascotaAdapter;
import com.example.loginregisterapp.adapters.ServiciosAdapter;
import com.example.loginregisterapp.pojos.Servicio;

import java.util.ArrayList;


public class ServiciosFragment extends Fragment {

    private View myFragment;
    RecyclerView recyclerViewServicios;
    ArrayList<Servicio> listaServicios;
    public ServiciosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment =  inflater.inflate(R.layout.fragment_servicios, container, false);
        recyclerViewServicios =  myFragment.findViewById(R.id.recycler_servicios);
        return myFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaServicios = new ArrayList<>();
        recyclerViewServicios.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        ServiciosAdapter serviciosAdapter = new ServiciosAdapter(listaServicios);
        recyclerViewServicios.setAdapter(serviciosAdapter);
    }

    private void llenarLista() {
        listaServicios.add(new Servicio("Estetica","https://raw.githubusercontent.com/jela3105/CanContentoFrontend/main/images/index/estetica.jpg","Se realiza un bano con corte de pelo y cepillado"));
        listaServicios.add(new Servicio("Veterinario","https://papelmatic.com/wp-content/uploads/2019/09/papelmatic-higiene-profesional-limpieza-desinfeccion-clinicas-veterinarias-1080x675.jpg","Se realiza una consulta general para saber el estado de salud de la mascota"));
        listaServicios.add(new Servicio("Corte de garras","https://blog.arion-petfood.es/wp-content/uploads/2015/05/154-Como-cortar-las-u%C3%B1as-a-un-perro-01_06-604x270.jpg","Se realiza un corte de garras, necesario para las mascotas"));

    }
}
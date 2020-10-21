package com.example.loginregisterapp.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.MascotaAdapter;
import com.example.loginregisterapp.pojos.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    View myFragment;
    RecyclerView recyclerViewMascotas;
    ArrayList<Mascota> listaMascotas;

    public MascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_mascotas, container, false);


        return myFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = myFragment.findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "hello mascotas", Toast.LENGTH_SHORT).show();
            }
        });

        listaMascotas = new ArrayList<>();
        recyclerViewMascotas =  myFragment.findViewById(R.id.recycler_mascotas);
        recyclerViewMascotas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();
        MascotaAdapter mascotaAdapter = new MascotaAdapter(listaMascotas);
        recyclerViewMascotas.setAdapter(mascotaAdapter);

    }

    private void llenarLista() {
        listaMascotas.add(new Mascota(R.drawable.jelaxd,"EL JELA XD", "EL PODEROSISIMO JELA"));
        listaMascotas.add(new Mascota(R.drawable.jelaxd,"EL JELA XD", "EL PODEROSISIMO JELA"));
        listaMascotas.add(new Mascota(R.drawable.jelaxd,"EL JELA XD", "EL PODEROSISIMO JELA"));
        listaMascotas.add(new Mascota(R.drawable.jelaxd,"EL JELA XD", "EL PODEROSISIMO JELA"));
    }


}

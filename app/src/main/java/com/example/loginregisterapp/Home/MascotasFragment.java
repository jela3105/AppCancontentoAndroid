package com.example.loginregisterapp.Home;

import android.content.Intent;
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

import com.example.loginregisterapp.MascotaActivity;
import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.MascotaAdapter;
import com.example.loginregisterapp.pojos.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    private View myFragment;
    private FloatingActionButton fab;
    private RecyclerView recyclerViewMascotas;
    private ArrayList<Mascota> listaMascotas;
    private SwipeRefreshLayout swipeRefreshLayoutMascotas;


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
        fab = myFragment.findViewById(R.id.add);
        recyclerViewMascotas =  myFragment.findViewById(R.id.recycler_mascotas);
        swipeRefreshLayoutMascotas = myFragment.findViewById(R.id.recargar_mascotas);
        return myFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startEditarMascota = new Intent(getContext(), MascotaActivity.class);
                startEditarMascota.putExtra("Action", "Add");
                getContext().startActivity(startEditarMascota);
            }
        });

        listaMascotas = new ArrayList<>();
        recyclerViewMascotas.setLayoutManager(new LinearLayoutManager(getContext()));
        fillList();
        MascotaAdapter mascotaAdapter = new MascotaAdapter(listaMascotas);
        recyclerViewMascotas.setAdapter(mascotaAdapter);

        swipeRefreshLayoutMascotas.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                emptyList();
                fillList();
                Toast.makeText(getContext(), "Se volvio a cargar", Toast.LENGTH_SHORT).show();
                swipeRefreshLayoutMascotas.setRefreshing(false);
            }
        });


    }

    private void emptyList(){
        listaMascotas.clear();
    }

    private void fillList() {
        listaMascotas.add(new Mascota("https://raw.githubusercontent.com/jela3105/CanContentoFrontend/main/images/index/estetica.jpg","El perrito", "Citas finalizadas: 0"));
        listaMascotas.add(new Mascota("https://raw.githubusercontent.com/jela3105/CanContentoFrontend/main/images/index/estetica.jpg","El segundo", "Citas finalizadas: 0"));
    }


}

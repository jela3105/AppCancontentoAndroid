package com.example.loginregisterapp.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.pojos.Cita;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CitasFragment extends Fragment {

    private View myFragment;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefreshLayoutCitas;
    private RecyclerView recyclerViewCitas;
    private ArrayList<Cita> listaCitas;

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

        //recargar mascotas
        swipeRefreshLayoutCitas.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Se volvio a cargar citas", Toast.LENGTH_SHORT).show();
                swipeRefreshLayoutCitas.setRefreshing(false);
            }
        });
    }
}
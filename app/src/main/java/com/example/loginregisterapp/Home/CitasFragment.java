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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.loginregisterapp.CitaActivity;
import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.CitaAdapter;
import com.example.loginregisterapp.pojos.DescripcionCita;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class CitasFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private View myFragment;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefreshLayoutCitas;
    private RecyclerView recyclerViewCitas;
    private ArrayList<DescripcionCita> listaCitas;
    private Spinner spinnerCitas;

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
        spinnerCitas = myFragment.findViewById(R.id.filtar_cita);

        String [] filtros = {"Ninguno","En espera","Confirmada","Cancelada","Finalizada"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, filtros);
        spinnerCitas.setAdapter(adapter);
        spinnerCitas.setOnItemSelectedListener(this);

        //lista de mascotas
        listaCitas = new ArrayList<>();
        recyclerViewCitas.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        CitaAdapter citaAdapter = new CitaAdapter(listaCitas);
        recyclerViewCitas.setAdapter(citaAdapter);
 
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
                Intent startAgendarCita = new Intent(getContext(), CitaActivity.class);
                //startAgendarCita.putExtra("nombreMascota",nombreMascota.getText());
                requireContext().startActivity(startAgendarCita);
            }
        });



        //recargar mascotas
        swipeRefreshLayoutCitas.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                vaciarLista();
                llenarLista();//hacer peticion
                spinnerCitas.setSelection(0);
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

        primero.setFoto("https://dam.vanidades.com/wp-content/uploads/2020/04/%C2%A1Como-si-necesit%C3%A1ramos-m%C3%A1s-razones-para-amar-a-los-perritos-Seg%C3%BAn-investigadores-el-mejor-amigo-del-hombre-podr%C3%ADa-ayudar-a-detectar-el-coronavirus..jpg");
        primero.setServicio("Corte de garras");
        primero.setStatus(1);
        primero.setMascota("El perrito");
        primero.setDescripcion("Se realiza un corte de garras muy chido");

        segundo.setFoto("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/59bbb29c5bafe878503c9872/husky-siberiano-bosque.jpg");
        segundo.setServicio("Baño especial");
        segundo.setStatus(2);
        segundo.setMascota("El segundo");
        segundo.setDescripcion("Se realiza un baño con shampoo de caballo");

        listaCitas.add(primero);
        listaCitas.add(segundo);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                //mostrar todo el array de la lista
                //Toast.makeText(getContext(), "Spinner limpio", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                //mostrar solo los que estan en espera (sin hacer la peticion)
                Toast.makeText(getContext(), "En espera", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getContext(), "Confirmada", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getContext(), "Cancelada", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getContext(), "Finalizada", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
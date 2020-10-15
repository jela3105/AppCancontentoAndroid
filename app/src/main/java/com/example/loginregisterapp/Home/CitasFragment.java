package com.example.loginregisterapp.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginregisterapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CitasFragment extends Fragment {

    View myFragment;

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
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_citas, container, false);
        FloatingActionButton fab = myFragment.findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "helloworld", Toast.LENGTH_SHORT).show();
            }
        });
        return myFragment;
    }

}
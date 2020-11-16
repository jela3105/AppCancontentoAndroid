package com.example.loginregisterapp.Perfil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.loginregisterapp.R;
import com.squareup.picasso.Picasso;


public class PerfilFragment extends Fragment {

    private View myFragment;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment =inflater.inflate(R.layout.fragment_perfil, container, false);;

        return  myFragment;
    }


}
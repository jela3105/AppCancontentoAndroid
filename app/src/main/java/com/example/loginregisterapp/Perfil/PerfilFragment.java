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
    private String URL_FOTO= "https://raw.githubusercontent.com/jela3105/CanContentoFrontend/main/images/index/estetica.jpg";
    private ImageView pruebaImagen;


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
        myFragment =inflater.inflate(R.layout.fragment_perfil, container, false);
        pruebaImagen = myFragment.findViewById(R.id.image_test);
        loadImageView();
        return  myFragment;
    }

    private void loadImageView() {
        Picasso.with(getContext()).load(URL_FOTO).into(pruebaImagen);
    }

}
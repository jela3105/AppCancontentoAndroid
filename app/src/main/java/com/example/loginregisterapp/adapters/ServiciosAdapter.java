package com.example.loginregisterapp.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServiciosAdapter  extends RecyclerView.Adapter<ServiciosAdapter.ServiciosViewHolder>{

    public class ServiciosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ServiciosViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }


    }

    @NonNull
    @Override
    public ServiciosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiciosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

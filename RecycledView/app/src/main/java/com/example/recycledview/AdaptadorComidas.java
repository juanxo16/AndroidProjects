package com.example.recycledview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorComidas extends RecyclerView.Adapter<AdaptadorComidas.ViewHolder> {
    private ArrayList<Comida> arrList;
    public AdaptadorComidas(ArrayList<Comida> listComida) {
        this.arrList = listComida;
    }

    @NonNull
    @Override
    public AdaptadorComidas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorComidas.ViewHolder holder, int position) {
        holder.asignarDatos(arrList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView texto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.textView);
            imagen = itemView.findViewById(R.id.imageView);
        }

        public void asignarDatos(Comida comida) {
            texto.setText(comida.getNombre());
            imagen.setImageResource(comida.getImagen());
        }
    }
}

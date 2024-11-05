package com.example.recycler_entrega;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorScuderias extends RecyclerView.Adapter<AdaptadorScuderias.ViewHolder> {
    private ArrayList<FormulaUno> arrList;
    private Context contexto;

    public AdaptadorScuderias(ArrayList<FormulaUno> arrList, Context contexto) {
        this.arrList = arrList;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public AdaptadorScuderias.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_f1, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorScuderias.ViewHolder holder, int position) {
        holder.asignarDatos(arrList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto, "Has seleccionado la escuderia: "+arrList.get(position).getEscuderia(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView texto;
        private TextView textoPilotos;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.textView);
            textoPilotos = itemView.findViewById(R.id.textView2);
            imagen = itemView.findViewById(R.id.imageView);
        }

        public void asignarDatos(FormulaUno f1) {
            texto.setText(f1.getEscuderia());
            textoPilotos.setText(f1.getPilotos());
            imagen.setImageResource(f1.getImagen());
        }

    }
}

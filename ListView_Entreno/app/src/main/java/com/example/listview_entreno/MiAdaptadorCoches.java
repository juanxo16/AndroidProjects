package com.example.listview_entreno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MiAdaptadorCoches extends ArrayAdapter<Coches> {
    private Context contexto;
    private int recurso;
    private ArrayList<Coches> arrayCochecito;


    public MiAdaptadorCoches(@NonNull Context context, int resource, @NonNull List<Coches> objects) {
        super(context, resource, objects);
        contexto  = context;
        recurso = resource;
        arrayCochecito = (ArrayList<Coches>) objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_layout, parent, false);

        TextView textMarca = view.findViewById(R.id.textView);
        TextView textModelo = view.findViewById(R.id.textView2);
        ImageView imagen = view.findViewById(R.id.imageView2);

        Coches coche = arrayCochecito.get(position);
        textMarca.setText(coche.getMarca());
        textModelo.setText(coche.getModelo());
        imagen.setImageResource(coche.getImagen());
        return view;
    }
}

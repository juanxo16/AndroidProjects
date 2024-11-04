package com.example.listview;

import android.content.Context;
import android.text.Layout;
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

public class MiAdaptadorCiudad extends ArrayAdapter<Ciudad> {

    private Context contexto;
    private int layoutCiudad;
    private List<Ciudad>arrayListCiudad;

    public MiAdaptadorCiudad(@NonNull Context context, int resource, @NonNull List<Ciudad> objects) {
        super(context, resource, objects);
        contexto = context;
        layoutCiudad = resource;
        arrayListCiudad = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(layoutCiudad,parent,false);


        TextView textNombre = (TextView) view.findViewById(R.id.textView3);
        TextView textDesc = (TextView) view.findViewById(R.id.textView4);
        ImageView imgCiudad = (ImageView) view.findViewById(R.id.imageView);

        Ciudad elementCiudad = arrayListCiudad.get(position);
        textNombre.setText(elementCiudad.getNombre());
        textDesc.setText(elementCiudad.getDescripcion());
        imgCiudad.setImageResource(elementCiudad.getImagen());
        return view;
    } 
}

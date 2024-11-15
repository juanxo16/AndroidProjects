package com.example.buscaminas_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorBomba extends ArrayAdapter<Bomba> {
    private Context contexto;
    private int layoutBomba;
    private List<Bomba> listaBombas;

    public MiAdaptadorBomba(Context context, int resource, List<Bomba> objets) {
        super(context, resource, objets);
        this.contexto = context;
        this.layoutBomba = resource;
        this.listaBombas = objets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(layoutBomba,parent,false);

        TextView txtNombre = view.findViewById(R.id.textView);

        ImageView img = view.findViewById(R.id.imageView);
        Bomba bomba = listaBombas.get(position);
        txtNombre.setText(bomba.getNombre());
        img.setImageResource(bomba.getImg());

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(layoutBomba,parent,false);

        TextView txtNombre = view.findViewById(R.id.textView);

        ImageView img = view.findViewById(R.id.imageView);
        Bomba bomba = listaBombas.get(position);
        txtNombre.setText(bomba.getNombre());
        img.setImageResource(bomba.getImg());

        return view;
    }
}

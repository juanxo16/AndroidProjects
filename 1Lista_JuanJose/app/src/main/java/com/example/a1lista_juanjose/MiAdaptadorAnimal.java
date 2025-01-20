package com.example.a1lista_juanjose;

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

/*
Autor:Juan José Hernández Montoya
Clase adaptador que hereda del arrayadapter<animal>, con su constructor y el metodo get view para crear la vista.
 */

public class MiAdaptadorAnimal extends ArrayAdapter<Animal> {

    private Context contexto;
    private int recurso;
    private ArrayList<Animal> arrAnimal = new ArrayList<>();

    public MiAdaptadorAnimal(@NonNull Context context, int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
        contexto = context;
        recurso = resource;
        arrAnimal = (ArrayList<Animal>) objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.animal_layout, parent, false);

        TextView txt = view.findViewById(R.id.textView);
        ImageView img = view.findViewById(R.id.imageView);

        Animal animal = arrAnimal.get(position);
        txt.setText(animal.getNombre());
        img.setImageResource(animal.getImagen());

        return view;
    }
}

package com.example.a1lista_juanjose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/*
Autor:Juan José Hernández Montoya
Clase main con  el arraylist y la lista declaradas, despues cargo el array con los datos, instancio el adaptador
y lo seteo a la lista. Por último uso un listener para poder que salga el mensaje al clickar cualquier elemento de la lista.
 */

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> arrayAnimal = new ArrayList<>();
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        arrayAnimal.add(new Animal(getResources().getString(R.string.caballo),R.drawable.caballo));
        arrayAnimal.add(new Animal(getResources().getString(R.string.gato),R.drawable.gato));
        arrayAnimal.add(new Animal(getResources().getString(R.string.oso),R.drawable.oso));
        arrayAnimal.add(new Animal(getResources().getString(R.string.leon),R.drawable.leon));
        arrayAnimal.add(new Animal(getResources().getString(R.string.mono),R.drawable.mono));
        arrayAnimal.add(new Animal(getResources().getString(R.string.zorro),R.drawable.zorro));
        arrayAnimal.add(new Animal(getResources().getString(R.string.vaca),R.drawable.vaca));

        MiAdaptadorAnimal adapter = new MiAdaptadorAnimal(this, R.layout.animal_layout,arrayAnimal);
        lista.setAdapter(adapter);
        
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has seleccionado: " + arrayAnimal.get(i).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
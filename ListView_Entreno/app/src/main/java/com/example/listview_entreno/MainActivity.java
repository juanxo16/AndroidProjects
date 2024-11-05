package com.example.listview_entreno;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Coches> arrayCoches = new ArrayList<Coches>();
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        arrayCoches.add(new Coches(getResources().getString(R.string.mercedes),getResources().getString(R.string.mercedesamg), R.drawable.merceamg));
        arrayCoches.add(new Coches(getResources().getString(R.string.fiat),getResources().getString(R.string.fiatmultipla), R.drawable.multipla));
        arrayCoches.add(new Coches(getResources().getString(R.string.audi),getResources().getString(R.string.audiatres), R.drawable.auditres));
        arrayCoches.add(new Coches(getResources().getString(R.string.opel),getResources().getString(R.string.opelcorsa), R.drawable.corsa));
        arrayCoches.add(new Coches(getResources().getString(R.string.porsche),getResources().getString(R.string.porschenueveonce), R.drawable.nueveonce));
        arrayCoches.add(new Coches(getResources().getString(R.string.renault),getResources().getString(R.string.renaultclio), R.drawable.clio));

        MiAdaptadorCoches adapter = new MiAdaptadorCoches(this, R.layout.item_layout, arrayCoches);
        lista.setAdapter(adapter);



    }
}
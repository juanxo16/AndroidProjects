package com.example.listview_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.lista1);
        array.add("Susana");
        array.add("Francisco");
        array.add("Ruben");
        array.add("Marta");
        array.add("Maria");
        array.add("Fernando");

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
        list.setAdapter(adaptador);
    }
}
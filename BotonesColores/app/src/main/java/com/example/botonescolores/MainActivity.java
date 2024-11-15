package com.example.botonescolores;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridLayout grid;
    Button boton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid1);

        for (int fila = 0;fila<grid.getRowCount();fila++){
            for (int col = 0;col<grid.getColumnCount();col++){

                boton = new Button(this);
                boton.setText("Fila "+fila+ " Col "+col);
                boton.setId(ViewGroup.generateViewId());

                // Con LayoutsParams establecemos las propiedades del widget boton
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(fila);
                params.columnSpec = GridLayout.spec(col);
                params.width=ViewGroup.LayoutParams.WRAP_CONTENT;
                params.height=ViewGroup.LayoutParams.WRAP_CONTENT;
                params.setMargins(10,10,10,10);

                grid.addView(boton, params);

                boton.setOnClickListener(view -> view.setBackgroundColor(Color.parseColor("purple")));
            }

        }



    }
}
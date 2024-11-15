package com.example.buscaminas_menu;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String dificultad = "";
    ArrayList<Bomba> arrayBombas = new ArrayList<>();
    GridLayout grid;
    Button boton;
    int j = 0;
    int [][] plantar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);


        arrayBombas.add(new Bomba(getResources().getString(R.string.ninguno), 0));
        arrayBombas.add(new Bomba(getResources().getString(R.string.minacla), R.drawable.bomba));
        arrayBombas.add(new Bomba(getResources().getString(R.string.minabomb), R.drawable.bombabomber));
        arrayBombas.add(new Bomba(getResources().getString(R.string.dinamita), R.drawable.dinamita));
        arrayBombas.add(new Bomba(getResources().getString(R.string.granada), R.drawable.granada));
        arrayBombas.add(new Bomba(getResources().getString(R.string.minasub), R.drawable.mina));
        arrayBombas.add(new Bomba(getResources().getString(R.string.coctelmolo), R.drawable.coctelmolotov));


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.instrucciones) {
            instruccionesDialog();
        } else if (item.getItemId() == R.id.comenzar) {
            if (dificultad.equals("") || dificultad.equals("Principiante")) {
                grid.removeAllViewsInLayout();
                grid.setRowCount(8);
                grid.setColumnCount(8);
                generarBombas(10);
                ajustarGrid();


            } else if (dificultad.equals("") || dificultad.equals("Amateur")) {
                grid.removeAllViewsInLayout();
                grid.setRowCount(12);
                grid.setColumnCount(12);
                generarBombas(30);
                ajustarGrid();

            } else if (dificultad.equals("") || dificultad.equals("Avanzado")) {
                grid.removeAllViewsInLayout();
                grid.setRowCount(16);
                grid.setColumnCount(16);
                generarBombas(60);
                ajustarGrid();

            }
        } else if (item.getItemId() == R.id.configurar) {
            dificultadDialog();
        } else if (item.getItemId() == R.id.personajes) {

            Spinner spn = new Spinner(this);

            // Configura el adaptador para el Spinner
            MiAdaptadorBomba adapter = new MiAdaptadorBomba(MainActivity.this, R.layout.layout_minas, arrayBombas);
            spn.setAdapter(adapter);


            AlertDialog.Builder dialogPersonajes = new AlertDialog.Builder(this);
            dialogPersonajes.setTitle("Seleccione un personaje");
            dialogPersonajes.setView(spn);
            dialogPersonajes.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    item.setIcon(arrayBombas.get(i).getImg());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    // No se seleccionó nada

                }
            });


            dialogPersonajes.create().show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void generarBombas(int bombas){
        Random rd =  new Random();
        plantar = new int[grid.getRowCount()][grid.getColumnCount()];
        int f = 0;
        int c = 0;
        for (int i = 0; i < bombas; i++) {
            do{
                f = rd.nextInt(grid.getRowCount());
                c = rd.nextInt(grid.getColumnCount());
            }while(plantar[f][c] == -1);
            plantar[f][c] = -1;
        }


    }

    private void ajustarGrid() {
        grid.removeAllViews();
        grid.removeAllViewsInLayout();
        int nFilas = grid.getRowCount();
        int nColumnas = grid.getColumnCount();

        for (int fila = 0; fila < grid.getRowCount(); fila++) {
            for (int columna = 0; columna < grid.getColumnCount(); columna++) {

                boton = new Button(this);

                boton.setId(grid.getColumnCount() * fila + columna);
                boton.setText(String.valueOf(grid.getColumnCount() * fila + columna));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(fila);
                params.columnSpec = GridLayout.spec(columna);
                params.width = grid.getWidth() / nFilas;
                params.height = grid.getHeight() / nColumnas;

                grid.addView(boton, params);
                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int a = view.getId() % grid.getColumnCount();
                        int b = view.getId() / grid.getColumnCount();
                        if(plantar[a][b] == -1){
                            view.setBackgroundColor(Color.parseColor("black"));
                        }else{
                            view.setBackgroundColor(Color.parseColor("green"));
                        }

                    }
                });
            }
        }
    }

    public void instruccionesDialog() {

        AlertDialog.Builder dlgInstrucciones = new AlertDialog.Builder(MainActivity.this);
        dlgInstrucciones.setTitle("Instrucciones");
        dlgInstrucciones.setMessage("Cuando pulsas en una casilla, sale un numero que identifica cuantas minas hay alrededor. Ten cuidado porque si pulsas " +
                "en una casilla que tenga una mina escondida, perderas. Si crees o tienes certeza de que hay una mina, haz un click largo " +
                "sobre la casilla para señalarla. No hagas un click largo en una casilla donde no hay una mina porqe perderas. Ganas una vez " +
                "hayas encontrado todas las minas.");
        dlgInstrucciones.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss());
        dlgInstrucciones.create().show();


    }

    public void dificultadDialog() {
        AlertDialog.Builder dlgDificultad = new AlertDialog.Builder(this);

        dlgDificultad.setTitle("Dificultad a elegir");
        dlgDificultad.setSingleChoiceItems(R.array.dificultad, -1, (dialogInterface, i) -> dificultad = getResources().getStringArray(R.array.dificultad)[i]);

        dlgDificultad.setPositiveButton("Volver", (dialogInterface, i) -> {
            if (dificultad != null && !dificultad.isEmpty()) {
                Toast.makeText(MainActivity.this, dificultad, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "No seleccionaste ningún elemento", Toast.LENGTH_SHORT).show();
            }
        });

        dlgDificultad.show();
    }
}
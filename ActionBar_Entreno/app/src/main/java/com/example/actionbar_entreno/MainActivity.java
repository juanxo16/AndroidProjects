package com.example.actionbar_entreno;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String dificultad;
    ArrayList<String> accesorios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.reglasjuego){
           dialogReglas();
        }else if(item.getItemId()==R.id.dificultad){
           dialogDificultad();
        }
        else if(item.getItemId()==R.id.accesorios){
           dialogAccesorios();
        }
        else if(item.getItemId()==R.id.infocreador){
           dialogCreador();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogReglas(){
        AlertDialog.Builder dialogRegla = new AlertDialog.Builder(MainActivity.this);
        dialogRegla.setTitle("Reglas del juego");
        dialogRegla.setMessage("Las reglas son ser el puto amo siempre");
        dialogRegla.setPositiveButton("Ok",(dialogInterface, i) -> dialogInterface.dismiss());
        dialogRegla.create().show();
    }

    public void dialogDificultad(){
        dificultad = null;
        AlertDialog.Builder dialogDificul = new AlertDialog.Builder(MainActivity.this);
        dialogDificul.setTitle("Dificultad");
        dialogDificul.setSingleChoiceItems(R.array.dificultad,-1,(dialogInterface, i) -> dificultad = getResources().getStringArray(R.array.dificultad)[i]);
        dialogDificul.setPositiveButton("Volver",(dialogInterface, i) ->
        {
            if(dificultad != null){
                Toast.makeText(this, "Dificultad seleccionada: "+dificultad, Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "Ninguna dificultad seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

        dialogDificul.create().show();
    }

    public void dialogAccesorios(){
        accesorios = new ArrayList<>();
        AlertDialog.Builder dialogAccesorios = new AlertDialog.Builder(MainActivity.this);
        dialogAccesorios.setTitle("Accesorios");
        dialogAccesorios.setMultiChoiceItems(R.array.accesorios,null,(dialogInterface, i, b) -> {
            if(b){
               accesorios.add(getResources().getStringArray(R.array.accesorios)[i]);
            }
        });
        dialogAccesorios.setPositiveButton("Confirmar",(dialogInterface, i) -> {
            if(accesorios != null){
                Toast.makeText(this, "Accesorios seleccionados: "+accesorios, Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "Ningún accesorio seleccionado", Toast.LENGTH_SHORT).show();
            }

        });


        dialogAccesorios.create().show();
    }
    public void dialogCreador(){
        AlertDialog.Builder dialogCreador = new AlertDialog.Builder(MainActivity.this);
        dialogCreador.setTitle("Creador del juego");
        dialogCreador.setMessage("El creador es Juan");
        dialogCreador.setPositiveButton("Ok",(dialogInterface, i) -> dialogInterface.dismiss());
        dialogCreador.create().show();
    }

}
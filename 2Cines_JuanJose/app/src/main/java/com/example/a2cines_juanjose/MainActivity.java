package com.example.a2cines_juanjose;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/*
Autor:Juan José Hernández Montoya
Clase main con los botones, texto e imagenes declaradas, el metodo para crear el menu, el metodo para ver que hay seleccionado
en el menu, y el metodo dialogPrecios con AlertBuilder para que salte el mensaje de los precios. Tambien el metodo para saber que
hay seleccionado en los radiobutton.
 */

public class MainActivity extends AppCompatActivity {

    RadioButton rb1, rb2;
    RadioGroup rg;
    TextView txt1;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rg = findViewById(R.id.radioGroup);
        txt1 = findViewById(R.id.textNombreCine);
        img1 = findViewById(R.id.imagenCine);

        //rb1.isFocusedByDefault(); CREO QUE ASI SE HACIA POR DEFECTO

        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            if(rb1.isChecked()){
                txt1.setText(R.string.cinemaNombre);
                img1.setImageResource(R.drawable.cinema);
            }else if(rb2.isChecked()){
                txt1.setText(R.string.cinepolisNombre);
                img1.setImageResource(R.drawable.cinepolis);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.precios){
            dialogPrecios();
        }else if(item.getItemId()==R.id.peliculas){
            Toast.makeText(this, "Has seleccionado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.buscar){
            Toast.makeText(this, "Has seleccionado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogPrecios(){
        AlertDialog.Builder dialogprec = new AlertDialog.Builder(this);
        dialogprec.setTitle("TARIFA PRECIOS");
        dialogprec.setMessage("Precio normal: 10€" +
                              "\n Carnet joven: 6€"+
                              "\n Jubilados: 5€");
        dialogprec.setPositiveButton("Aceptar", (dialogInterface, i) -> dialogInterface.dismiss());
        dialogprec.create().show();
    }
}
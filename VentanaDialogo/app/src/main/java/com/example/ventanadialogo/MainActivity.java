package com.example.ventanadialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1, boton2, boton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);


        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            dialogAlert();
        } else if (view.getId() == R.id.button2) {
            dialogList();
        }else if (view.getId() == R.id.button3) {
            dialogoFecha();
        }
    }

    private void dialogoFecha(){
        Calendar calendar =  Calendar.getInstance();
        int cal_anno = calendar.get(Calendar.YEAR);
        int cal_mes = calendar.get(Calendar.MONTH);
        int cal_dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpdDate = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int annio, int mes, int dia) {
                Toast.makeText(MainActivity.this, "La fecha seleccionada es: " + String.valueOf(dia) +"/"+ String.valueOf(mes+1) +"/"+ String.valueOf(annio), Toast.LENGTH_SHORT).show();
            }
        }, cal_anno, cal_mes, cal_dia);
        dpdDate.show();
    }


    private void dialogList() {

        final String[] nav = getResources().getStringArray(R.array.lista_nav);
        AlertDialog.Builder dlgLista = new AlertDialog.Builder(MainActivity.this);
        dlgLista.setTitle("Elige un navegador");
        dlgLista.setItems(nav, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "El navegador seleccionado es " + nav[i], Toast.LENGTH_SHORT).show();
            }
        });
        dlgLista.create().show();

    }

    private void dialogAlert() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setMessage("¿Empezar el juego?");
        dialogo.setTitle("Bienvenido");
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Empieza el juego", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "El juego acaba", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        dialogo.create().show();
    }
}


package com.example.banderitas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int [] banderas = {R.drawable.albania, R.drawable.bulgaria, R.drawable.camerun, R.drawable.cuba, R.drawable.colombia,
            R.drawable.finlandia, R.drawable.georgia, R.drawable.suiza, R.drawable.turquia, R.drawable.venezuela};
    String [] paises = {"Albania", "Bulgaria", "Camerún", "Cuba", "Colombia", "Finlandia",
            "Guernsey", "Suiza", "Turquía", "Venezuela"};

    Random rd = new Random();
    int temp1 = rd.nextInt(banderas.length);
    int temp2 = rd.nextInt(banderas.length);
    int temp3 = 0;
    int puntos = 0;
    List<Integer> usados = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton bt1 = findViewById(R.id.imageButton);
        ImageButton bt2 = findViewById(R.id.imageButton2);
        Button btinicio = findViewById(R.id.button);
        Button btfinal = findViewById(R.id.button2);
        TextView txt1 = findViewById(R.id.textView);
        TextView txt2 = findViewById(R.id.textView2);



        while(temp2 == temp1){

            temp2 = rd.nextInt(banderas.length);

        }

        bt1.setVisibility(View.INVISIBLE);
        bt2.setVisibility(View.INVISIBLE);
        txt1.setVisibility(View.INVISIBLE);
        txt2.setVisibility(View.INVISIBLE);
        btinicio.setVisibility(View.VISIBLE);
        btfinal.setVisibility(View.INVISIBLE);




        btinicio.setOnClickListener(view -> {

            bt1.setImageResource(banderas[temp1]);
            bt2.setImageResource(banderas[temp2]);


            btinicio.setVisibility(View.GONE);


            temp3 = rd.nextInt(2);
            if(temp3==0){
                txt1.setText("Pulsa bandera de: " + paises[temp1]);
            }
            else {
                txt1.setText("Pulsa bandera de: " + paises[temp2]);
            }

            bt1.setVisibility(View.VISIBLE);
            bt2.setVisibility(View.VISIBLE);
            btfinal.setVisibility(View.VISIBLE);
            txt1.setVisibility(View.VISIBLE);
            txt2.setVisibility(View.VISIBLE);
            txt2.setText("Puntos: " + puntos);


        });



        bt1.setOnClickListener(view -> {

            if(temp3==0){

                Toast.makeText(MainActivity.this, "Correcto",Toast.LENGTH_SHORT).show();
                puntos += 10;
                txt2.setText("Puntos: " + puntos);
                usados.add(banderas[temp1]);
                do{
                    temp1 = rd.nextInt(banderas.length);
                }while(usados.contains(banderas[temp1]));

            }else{
                Toast.makeText(MainActivity.this, "Incorrecto",Toast.LENGTH_SHORT).show();
                puntos -= 10;
                txt2.setText("Puntos: " + puntos);
                do {
                    temp1 = rd.nextInt(banderas.length);
                } while (usados.contains(banderas[temp1]));
            }

            do {
                temp2 = rd.nextInt(banderas.length);
            } while (temp2 == temp1 || usados.contains(banderas[temp2]));

            bt1.setImageResource(banderas[temp1]);
            bt2.setImageResource(banderas[temp2]);

            temp3 = rd.nextInt(2);
            if(temp3==0){
                txt1.setText("Pulsa bandera de: " + paises[temp1]);
            }
            else {
                txt1.setText("Pulsa bandera de: " + paises[temp2]);
            }



        });

        bt2.setOnClickListener(view -> {

            if(temp3==1){

                Toast.makeText(MainActivity.this, "Correcto",Toast.LENGTH_SHORT).show();
                puntos += 10;
                txt2.setText("Puntos: " + puntos);
                usados.add(banderas[temp2]);
                do{
                    temp2 = rd.nextInt(banderas.length);
                }while(usados.contains(banderas[temp2]));
            }

            else{
                Toast.makeText(MainActivity.this, "Incorrecto",Toast.LENGTH_SHORT).show();
                puntos -= 10;
                txt2.setText("Puntos: " + puntos);
                do{
                    temp2 = rd.nextInt(banderas.length);
                }while(usados.contains(banderas[temp2]));
            }


            do {
                temp1 = rd.nextInt(banderas.length);
            } while (temp1 == temp2 || usados.contains(banderas[temp1]));

            bt1.setImageResource(banderas[temp1]);
            bt2.setImageResource(banderas[temp2]);

            temp3 = rd.nextInt(2);
            if(temp3==0){
                txt1.setText("Pulsa bandera de: " + paises[temp1]);
            }
            else {
                txt1.setText("Pulsa bandera de: " + paises[temp2]);
            }

        });

btfinal.setOnClickListener(view -> {

    bt1.setVisibility(View.INVISIBLE);
    bt2.setVisibility(View.INVISIBLE);
    txt1.setVisibility(View.INVISIBLE);
    txt2.setVisibility(View.INVISIBLE);
    btinicio.setVisibility(View.VISIBLE);
    btfinal.setVisibility(View.INVISIBLE);
    puntos = 0;
    usados.clear();

});

    }
}
package com.example.togglebutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    ImageView img1;
    ToggleButton tgb1;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt1 = findViewById(R.id.textView);
        img1 = findViewById(R.id.imageView);
        tgb1 = findViewById(R.id.toggleButton);


        tgb1.setOnCheckedChangeListener((compoundButton, b) -> {

            if(b){

                tgb1.getTextOn();
                img1.setImageResource(R.drawable.colgar);
                txt1.setText(" ");


            }
            else{
                tgb1.getTextOff();
                img1.setImageResource(R.drawable.llamar);
                txt1.setText("Llamando...");

            }
        });

    }
}
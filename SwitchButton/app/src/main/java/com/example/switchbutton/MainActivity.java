package com.example.switchbutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageView);
        sw1 = findViewById(R.id.switch1);


sw1.setOnCheckedChangeListener((compoundButton, b) -> {
    if(b){

        sw1.setText(sw1.getTextOn());
        img1.setImageResource(R.drawable.walterwhitesombrero);



    }
    else{

        sw1.setText(sw1.getTextOff());
        img1.setImageResource(R.drawable.walterwhitecalvo);


    }
});

    }
}
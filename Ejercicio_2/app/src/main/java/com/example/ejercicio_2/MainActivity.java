package com.example.ejercicio_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.button);
        EditText texto1 = findViewById(R.id.editTextText2);

        boton.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Bienvenido "+texto1.getText(),Toast.LENGTH_SHORT).show());


    }
}
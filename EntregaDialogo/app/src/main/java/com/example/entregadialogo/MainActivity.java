package com.example.entregadialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton1, boton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boton1 = findViewById(R.id.button);
        boton2 = findViewById(R.id.button2);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);




    }

    private void instruccionesMensaje(){

    }
    private void dialogList() {

        final String[] nav = getResources().getStringArray(R.array.dificultad);
        AlertDialog.Builder dlgLista = new AlertDialog.Builder(MainActivity.this);
        dlgLista.setTitle("Dificultad");
        dlgLista.setPositiveButton(nav, (DialogInterface.OnClickListener) (dialogInterface, i) -> Toast.makeText(MainActivity.this, "La dificultad seleccionada es:  " + nav[i], Toast.LENGTH_SHORT).show())
        );
        dlgLista.create().show();

    }
}
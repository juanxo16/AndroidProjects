package com.example.recycler_entrega;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerc;
    ArrayList<FormulaUno> listEscuderias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerc = findViewById(R.id.recyclerc);
        recyclerc.setLayoutManager(new GridLayoutManager(this, 2));


        listEscuderias.add(new FormulaUno(R.drawable.alpine,getResources().getString(R.string.alpine),getResources().getString(R.string.alpinepilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.aston,getResources().getString(R.string.astonmartin),getResources().getString(R.string.astonmartinpilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.ferrari,getResources().getString(R.string.ferrari),getResources().getString(R.string.ferraripilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.haas,getResources().getString(R.string.haas),getResources().getString(R.string.haaspilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.rb,getResources().getString(R.string.rbcashvisa),getResources().getString(R.string.rbcashvisapilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.mclaren,getResources().getString(R.string.mclaren),getResources().getString(R.string.mclarenpilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.mercedes,getResources().getString(R.string.mercedes),getResources().getString(R.string.mercedespilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.stake,getResources().getString(R.string.stake),getResources().getString(R.string.stakepilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.redbull,getResources().getString(R.string.redbull),getResources().getString(R.string.redbullpilotos)));
        listEscuderias.add(new FormulaUno(R.drawable.williams,getResources().getString(R.string.williams),getResources().getString(R.string.williamspilotos)));

        recyclerc.setAdapter(new AdaptadorScuderias(listEscuderias,this));


    }
}
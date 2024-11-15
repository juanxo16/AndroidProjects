package com.example.radiobtton_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rbt1, rbt2;
        RadioGroup rgr1;
        TextView txt1;
        CheckBox ch1;

        rbt1 = findViewById(R.id.radioButton);
        rbt2 = findViewById(R.id.radioButton2);
        ch1 = findViewById(R.id.checkBox);

        rgr1 = findViewById(R.id.radioGroup);

        txt1 = findViewById(R.id.textView);

        rgr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButton){
                    txt1.setText(getString(R.string.texto) + " " + rbt1.getText());
                }
                else{
                    txt1.setText(getString(R.string.texto) + " " + rbt2.getText());
                }
            }
        });

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Te gusta programar",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "No te gusta programar, pues te reviento ",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
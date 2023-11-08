package com.example.ejerciciorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaFinal extends AppCompatActivity {

    private TextView textAciertos, textFallos;
    private int aciertos, fallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);


        //Iniciar las vistas
        textAciertos = findViewById(R.id.textViewAciertos);
        textFallos = findViewById(R.id.textViewFallos);


        //recuperar los datos de la intent
        Intent intent = getIntent();
        if(intent != null){
             aciertos = intent.getIntExtra("aciertos", 0);
             fallos = intent.getIntExtra("fallos", 0);
            Toast.makeText(PantallaFinal.this, "Datos recuperados correctamente", Toast.LENGTH_SHORT).show();

            //pintar aciertos y fallos en la pantalla final
            String stringAciertos = "Aciertos: " + String.valueOf(aciertos);
            String stringFallos = "Fallos: " + String.valueOf(fallos);

            textAciertos.setText(stringAciertos);
            textFallos.setText(stringFallos);
        }else {
            Toast.makeText(PantallaFinal.this, "No se han podido recuperar los datos, intent nula", Toast.LENGTH_SHORT).show();
        }

    }
}
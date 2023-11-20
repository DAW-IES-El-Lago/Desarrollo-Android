package com.melaku.daw.examenandroidmelakugarcia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int MAX_SALON = 40;
    private final int MAX_GENERAL = 15;
    private int aforoGeneral = 0, aforoSalon = 0;
    private int aforoTotal = aforoGeneral + aforoSalon;
    TextView salonTv;
    TextView generalTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //iniciar variables con referencia a las vistas
        generalTv = findViewById(R.id.generalTv);
        salonTv = findViewById(R.id.salonTv);
        Button botonSumarGeneral = findViewById(R.id.sumarGeneral);
        Button botonRestarGeneral = findViewById(R.id.restarGeneral);
        Button botonSumarSalon = findViewById(R.id.sumarSalon);
        Button botonRestarSalon = findViewById(R.id.restarSalon);
        Button finalizarButton = findViewById(R.id.finalizar);


        botonSumarGeneral.setOnClickListener(v -> {
            aforoGeneral = sumarAforo(MAX_GENERAL, aforoGeneral, generalTv);
            Log.i("Depuraciones","Aforo general: " +  aforoGeneral);
        });

        botonRestarGeneral.setOnClickListener(v -> {
           aforoGeneral = restarAforo(MAX_GENERAL, aforoGeneral, generalTv);
            Log.i("Depuraciones","Aforo general: " +  aforoGeneral);
        });

        botonSumarSalon.setOnClickListener(v -> {
            aforoSalon = sumarAforo(MAX_GENERAL, aforoSalon, salonTv);
            Log.i("Depuraciones","Aforo salon: " +  aforoSalon);
        });

        botonRestarSalon.setOnClickListener(v -> {
            aforoSalon = restarAforo(MAX_GENERAL, aforoSalon, salonTv);
            Log.i("Depuraciones", "Aforo salon: " + aforoSalon);
        });

        finalizarButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, PantallaFinal.class);
            aforoTotal = aforoGeneral + aforoSalon;
            i.putExtra("aforoSalon", aforoSalon);
            i.putExtra("aforoGeneral", aforoGeneral);
            i.putExtra("aforoTotal", aforoTotal);
            startActivity(i);
        });

    }

    private int sumarAforo(int max, int aforo, TextView v){
        if(aforo < max){
            aforo++;
            actualizarUI(aforo, v);
        }else{
            Toast.makeText(MainActivity.this, "No Cabe mas gente", Toast.LENGTH_SHORT).show();
        }
        return aforo;
    }

    private int restarAforo(int max, int aforo, TextView v){
        if(aforo > 0){
            aforo--;
            actualizarUI(aforo ,v);
        }else{
            Toast.makeText(MainActivity.this, "Ya esta vacio", Toast.LENGTH_SHORT).show();
        }
        return aforo;
    }


    private void actualizarUI(int cantidad, TextView v){
        String s = String.valueOf(cantidad);
        v.setText(s);
    }
}
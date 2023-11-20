package com.melaku.daw.examenandroidmelakugarcia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PantallaFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        TextView salonTv = findViewById(R.id.salonFinal);
        TextView generalTv = findViewById(R.id.generalFinal);
        TextView totalTv = findViewById(R.id.totalFinal);

        Intent i = getIntent();
        int salon = i.getIntExtra("aforoSalon", 0);
        int general = i.getIntExtra("aforoGeneral", 0);
        int total = i.getIntExtra("aforoTotal", 0);


        generalTv.setText(String.valueOf(general));
        salonTv.setText(String.valueOf(salon));
        totalTv.setText(String.valueOf(total));


        Toolbar tb = (Toolbar) findViewById(R.id.toolbarFinal);
        setSupportActionBar(tb);
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle("Volver");
        }
    }
}
package com.example.ejerciciorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titulo;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private Button botonAvanzar, botonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociar variable a vistas

        titulo = findViewById(R.id.tituloApp);
        imagen1 = findViewById(R.id.imagen1);
        imagen2 = findViewById(R.id.imagen2);
        imagen3 = findViewById(R.id.imagen3);
        imagen4 = findViewById(R.id.imagen4);
        botonAvanzar = findViewById(R.id.boton1);
        botonFinalizar = findViewById(R.id.boton2);


        //crear preguntas con su constructor
        Pregunta p1 = new Pregunta(R.drawable.coche1, R.drawable.coche2, R.drawable.coche3, R.drawable.burro, R.drawable.burro);
        Pregunta p2 = new Pregunta(R.drawable.paris, R.drawable.londres, R.drawable.japon, R.drawable.roma, R.drawable.japon);
        Pregunta p3 = new Pregunta(R.drawable.bird1, R.drawable.dog, R.drawable.bird2, R.drawable.bird3, R.drawable.dog);

        //crear lista preguntas y meter preguntas a la lista
        ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
        int index = 0;

        Log.i("depuranding", "Tamaño de listaPreguntas: " + listaPreguntas.size());

        listaPreguntas.add(p1);
        listaPreguntas.add(p2);
        listaPreguntas.add(p3);

        //pintamos el layout de la primera pregunta en nuestro caso ya la tenemos pintada en el xml
        //Pintar(index, listaPreguntas);

        //EVALUAR SI LA PREGUNTA ES CORRECTA O SI SE PULSO NEXT

        botonAvanzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index == 0){
                    Pintar(index, a);
                    index++;
                }else if(0 < index && index < a.size() - 1){
                    Pintar(index, a);
                    index++;
                }else {
                    Toast.makeText(MainActivity.this, "No quedan mas preguntas",  Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.i("depuranding", "Valor de índice fuera: " + index);

    }

    private void Pintar(int indice, ArrayList <Pregunta> a){
        imagen1.setImageResource(a.get(indice).getIdImagen1());
        imagen2.setImageResource(a.get(indice).getIdImagen2());
        imagen3.setImageResource(a.get(indice).getIdImagen3());
        imagen4.setImageResource(a.get(indice).getIdImagen4());
    }


    /*
    private int AvanzarPregunta(int indice, ArrayList <Pregunta> a){
        Log.i("depuranding", "Valor de índice al entrar a Avanzar: " + indice);
        if(indice == 0){
            Pintar(indice, a);
            indice++;
        }else if(0 < indice && indice < a.size() - 1){
            Pintar(indice, a);
            indice++;
        }else {
            Toast.makeText(MainActivity.this, "No quedan mas preguntas",  Toast.LENGTH_SHORT).show();
        }
        Log.i("depuranding", "Valor de índice antes de ser retornado: " + indice);
        return indice;
    }

    private int RetrocederPregunta(int indice, ArrayList <Pregunta> a){
        if(0 <= indice && indice < a.size()){
            indice--;
            Pintar(indice, a);
        }
        return indice;
    }

     */
}
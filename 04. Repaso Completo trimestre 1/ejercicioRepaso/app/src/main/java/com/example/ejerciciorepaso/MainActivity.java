package com.example.ejerciciorepaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.ejerciciorepaso.ACIERTOSFALLOS";
    private TextView titulo;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private Button botonAvanzar, botonRetroceder, botonFinalizar;
    private int index = 0; // Declarar la variable index fuera de onCreate
    private int aciertos = 0, fallos = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociar variable a vistas
        titulo = findViewById(R.id.tituloApp);
        imagen1 = findViewById(R.id.imagen1);
        imagen2 = findViewById(R.id.imagen2);
        imagen3 = findViewById(R.id.imagen3);
        imagen4 = findViewById(R.id.imagen4);
        botonAvanzar = findViewById(R.id.boton1);
        botonRetroceder = findViewById(R.id.boton2);
        botonFinalizar = findViewById(R.id.boton3);

        //Configurar la toolbar
        Toolbar toolbar = findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu de Navegacion");


        // Crear preguntas con su constructor
        Pregunta p1 = new Pregunta(R.drawable.coche1, R.drawable.coche2, R.drawable.coche3, R.drawable.burro, R.drawable.burro);
        Pregunta p2 = new Pregunta(R.drawable.paris, R.drawable.londres, R.drawable.japon, R.drawable.roma, R.drawable.japon);
        Pregunta p3 = new Pregunta(R.drawable.bird1, R.drawable.dog, R.drawable.bird2, R.drawable.bird3, R.drawable.dog);

        // Crear lista preguntas y meter preguntas a la lista
        ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
        listaPreguntas.add(p1);
        listaPreguntas.add(p2);
        listaPreguntas.add(p3);

        Log.i("depuranding", "Tamaño de listaPreguntas: " + listaPreguntas.size());

        // Pintamos el layout de la primera pregunta en nuestro caso ya la tenemos pintada en el xml
        Pintar(index, listaPreguntas);

        // Eventos de click de los botones

        botonAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AvanzarPregunta(listaPreguntas);
            }
        });

        botonRetroceder.setOnClickListener(v -> RetrocederPregunta(listaPreguntas));

        botonFinalizar.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Se acabo", Toast.LENGTH_SHORT));

        //Eventos de click de las imagenes

        imagen1.setOnClickListener(v -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen1()));
        imagen2.setOnClickListener(v -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen2()));
        imagen3.setOnClickListener(v -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen3()));
        imagen4.setOnClickListener(v -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen4()));

        //Evento del boton finalizar

        botonFinalizar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantallaFinal.class);
            String aciertoString = String.valueOf(aciertos);
            intent.putExtra(EXTRA_MESSAGE, aciertoString);
            intent.putExtra("aciertos", aciertos);
            intent.putExtra("fallos", fallos);
            startActivity(intent);

        });

        Log.i("depuranding", "Valor de índice fuera: " + index);
    }

    private void Pintar(int indice, ArrayList<Pregunta> a) {
        imagen1.setImageResource(a.get(indice).getIdImagen1());
        imagen2.setImageResource(a.get(indice).getIdImagen2());
        imagen3.setImageResource(a.get(indice).getIdImagen3());
        imagen4.setImageResource(a.get(indice).getIdImagen4());
    }

    private void AvanzarPregunta(ArrayList<Pregunta> a) {
        Log.i("depuranding", "Valor de índice al entrar a Avanzar: " + index);
        if (index < a.size() - 1) {
            index++;
            Pintar(index, a);
        } else {
            Toast.makeText(MainActivity.this, "No quedan más preguntas", Toast.LENGTH_SHORT).show();
        }
        Log.i("depuranding", "Valor de índice antes de ser retornado: " + index);
    }

    private void RetrocederPregunta(ArrayList<Pregunta> a) {
        if (index > 0) {
            index--;
            Pintar(index, a);
        } else {
            Toast.makeText(MainActivity.this, "Esta es la primera pregunta", Toast.LENGTH_SHORT).show();
        }
    }

    private void verificarRespuesta(Pregunta p, int id){
        if(p.getCorrecta() == id){
            aciertos++;
            Toast.makeText(MainActivity.this, "Has encontrado al impostor!", Toast.LENGTH_SHORT).show();
        }else {
            fallos++;
            Toast.makeText(MainActivity.this, "Has Fallado!", Toast.LENGTH_SHORT).show();
        }
    }

}

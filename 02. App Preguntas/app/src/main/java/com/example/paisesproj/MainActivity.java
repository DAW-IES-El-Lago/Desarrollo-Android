package com.example.paisesproj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button optionButtonA, optionButtonB, optionButtonC;
    private TextView textViewPregunta, textViewOptionA, textViewOptionB, textViewOptionC;
    private List<Pregunta> preguntas;
    private int preguntaActualIndex;
    private int contadorAciertos = 0;
    private int contadorErrores = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las vistas
        textViewPregunta = findViewById(R.id.textViewPreguntas);
        imageView = findViewById(R.id.imageView);

        optionButtonA = findViewById(R.id.optionButtonA);
        optionButtonB = findViewById(R.id.optionButtonB);
        optionButtonC = findViewById(R.id.optionButtonC);

        textViewOptionA = findViewById(R.id.textViewOptionA);
        textViewOptionB = findViewById(R.id.textViewOptionB);
        textViewOptionC = findViewById(R.id.textViewOptionC);

        // Lista de preguntas
        preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("Cual es la Capital de Alemania?", R.drawable.berlin_img, "Munich", "Berlin", "Frankfurt", optionButtonB.getId()));

        preguntaActualIndex = 0; // Inicializa el índice de la pregunta actual

        mostrarPregunta(); // Muestra la primera pregunta

        preguntas.add(new Pregunta("¿Cuál es la capital de Francia?", R.drawable.paris_img, "Madrid", "Roma", "París", optionButtonC.getId()));
        preguntas.add(new Pregunta("¿Cuál es el río más largo del mundo?", R.drawable.amazonas_img, "Amazonas", "Nilo", "Misisipi", optionButtonA.getId()));
        preguntas.add(new Pregunta("¿Cuál es el océano más grande del mundo?", R.drawable.pacific_img, "Océano Pacífico", "Océano Atlántico", "Océano Índico", optionButtonA.getId()));
        preguntas.add(new Pregunta("¿Cuál es el monte más alto del mundo?", R.drawable.everest_img, "Monte Everest", "Monte Kilimanjaro", "Monte McKinley", optionButtonA.getId()));
        preguntas.add(new Pregunta("¿Cuál es el continente más poblado del mundo?", R.drawable.asia_img, "Asia", "África", "Europa", optionButtonA.getId()));
        preguntas.add(new Pregunta("¿Quién es esta actriz?", R.drawable.cameron, "Ana de Armas", "Cameron Diaz", "Margot Robbie", optionButtonB.getId()));

    }

    private void mostrarPregunta() {
        if (preguntaActualIndex < preguntas.size()) {
            Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
            configurarPregunta(preguntaActual);
        } else {
            // Has completado todas las preguntas
            textViewPregunta.setText("Aciertos: " + contadorAciertos + " | Errores: " + contadorErrores);
            imageView.setVisibility(View.GONE); // Oculta la imagen
            optionButtonA.setVisibility(View.GONE); // Oculta los botones de opciones
            optionButtonB.setVisibility(View.GONE);
            optionButtonC.setVisibility(View.GONE);
            textViewOptionA.setVisibility(View.GONE); // Oculta los tedxtos de opciones
            textViewOptionB.setVisibility(View.GONE);
            textViewOptionC.setVisibility(View.GONE);
        }
    }

    private void configurarPregunta(Pregunta pregunta) {
        textViewPregunta.setText(pregunta.getPregunta());
        imageView.setImageResource(pregunta.getIdImagen());
        textViewOptionA.setText(pregunta.getOpcionA());
        textViewOptionB.setText(pregunta.getOpcionB());
        textViewOptionC.setText(pregunta.getOpcionC());

        optionButtonA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                comprobarRespuesta(pregunta, optionButtonA);
            }
        });

        optionButtonB.setOnClickListener(view -> comprobarRespuesta(pregunta, optionButtonB));
        optionButtonC.setOnClickListener(view -> comprobarRespuesta(pregunta, optionButtonC));
    }

    private void comprobarRespuesta(Pregunta pregunta, Button seleccionado) {
        int idRespuestaCorrecta = pregunta.getRespuestaCorrecta();

        if (seleccionado.getId() == idRespuestaCorrecta) {
            showToast("Correcto!");
            contadorAciertos++; // Incrementa el contador de aciertos
        } else {
            showToast("Incorrecto");
            contadorErrores++; // Incrementa el contador de errores
        }

        // Cambia a la siguiente pregunta
        preguntaActualIndex++;
        mostrarPregunta(); // Muestra la siguiente pregunta
    }

    private void showToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


}

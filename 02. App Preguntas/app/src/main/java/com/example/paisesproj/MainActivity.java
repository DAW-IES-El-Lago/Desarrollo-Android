package com.example.paisesproj;

import android.media.MediaPlayer;
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

    MediaPlayer mediaPlayerAcierto;
    MediaPlayer mediaPlayerError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Inicializa los MediaPlayer
        mediaPlayerAcierto = MediaPlayer.create(this, R.raw.correct);
        mediaPlayerError = MediaPlayer.create(this, R.raw.error);

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
        preguntas.add(new Pregunta(getString(R.string.question_0), R.drawable.berlin_img, getString(R.string.option_A_q0), getString(R.string.option_B_q0), getString(R.string.option_C_q0), optionButtonB.getId()));

        preguntaActualIndex = 0; // Inicializa el índice de la pregunta actual

        mostrarPregunta(); // Muestra la primera pregunta

        preguntas.add(new Pregunta(getString(R.string.question_1), R.drawable.paris_img, getString(R.string.option_A_q1), getString(R.string.option_B_q1), getString(R.string.option_C_q1), optionButtonC.getId()));
        preguntas.add(new Pregunta(getString(R.string.question_2), R.drawable.amazonas_img, getString(R.string.option_A_q2), getString(R.string.option_B_q2), getString(R.string.option_C_q2), optionButtonA.getId()));
        preguntas.add(new Pregunta(getString(R.string.question_3), R.drawable.pacific_img, getString(R.string.option_A_q3), getString(R.string.option_B_q3), getString(R.string.option_C_q3), optionButtonA.getId()));
        preguntas.add(new Pregunta(getString(R.string.question_4), R.drawable.everest_img, getString(R.string.option_A_q4), getString(R.string.option_B_q4), getString(R.string.option_C_q4), optionButtonA.getId()));
        preguntas.add(new Pregunta(getString(R.string.question_5), R.drawable.asia_img, getString(R.string.option_A_q5), getString(R.string.option_B_q5), getString(R.string.option_C_q5), optionButtonA.getId()));
        preguntas.add(new Pregunta(getString(R.string.question_6), R.drawable.cameron, getString(R.string.option_A_q6), getString(R.string.option_B_q6), getString(R.string.option_C_q6), optionButtonB.getId()));

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
            mediaPlayerAcierto.start();
            contadorAciertos++; // Incrementa el contador de aciertos
        } else {
            showToast("Incorrecto");
            mediaPlayerError.start();
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

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
        preguntas.add(new Pregunta(
                textViewPregunta.getId(),
                imageView.getId(),
                textViewOptionA.getId(),
                textViewOptionB.getId(),
                textViewOptionC.getId(),
                textViewOptionA.getId()
        ));

        //Segunda pregunta
        Pregunta nuevaPregunta = new Pregunta(
                textViewPregunta.getId(),
                imageView.getId(),
                textViewOptionA.getId(),
                textViewOptionB.getId(),
                textViewOptionC.getId(),
                textViewOptionC.getId()
        );

        nuevaPregunta.setPregunta("¿Cuál es la capital de Alemania?");
        nuevaPregunta.setIdImagen(R.drawable.berlin_img);
        nuevaPregunta.setIdOpcion1(optionButtonA.getId());
        nuevaPregunta.setIdOpcion2(optionButtonB.getId());
        nuevaPregunta.setIdOpcion3(optionButtonC.getId());
        nuevaPregunta.setIdRespuestaCorrecta(optionButtonB.getId());

        preguntas.add(nuevaPregunta);

        //Tercera pregunta
        Pregunta terceraPregunta = new Pregunta(
                textViewPregunta.getId(),
                imageView.getId(),
                textViewOptionA.getId(),
                textViewOptionB.getId(),
                textViewOptionC.getId(),
                textViewOptionC.getId()
        );

        //bindear los botones y respuesta correcta
        terceraPregunta.setPregunta("¿Qué montaña es esa?");
        terceraPregunta.setIdImagen(R.drawable.japan_img);
        terceraPregunta.setIdOpcion1(optionButtonA.getId());
        terceraPregunta.setIdOpcion2(optionButtonB.getId());
        terceraPregunta.setIdOpcion3(optionButtonC.getId());
        terceraPregunta.setIdRespuestaCorrecta(optionButtonC.getId());

        //cambiar las opciones no esta disponible

        preguntas.add(terceraPregunta);


        //cuarta pregunta
        Pregunta cuartaPregunta = new Pregunta(4, R.drawable.cameron, textViewOptionA.getId(), textViewOptionB.getId(), textViewOptionC.getId(), textViewOptionC.getId());
        cuartaPregunta.setPregunta("Qien es ella?");
        preguntas.add(cuartaPregunta);


        // Configurar los clicks de botones solo llaman el metodo verificarRespuesta que evalua si son correcta y suma los aciertos/errores
        optionButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(textViewOptionA.getId());
            }
        });

        optionButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(textViewOptionB.getId());
            }
        });

        optionButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(textViewOptionC.getId());
            }
        });
    }

    private void mostrarPregunta() {
        Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
        textViewPregunta.setText(preguntaActual.getPregunta());
        imageView.setImageDrawable(getDrawable(preguntaActual.getIdImagen()));
    }

    private void verificarRespuesta(int idOpcionSeleccionada) {
        Pregunta preguntaActual = preguntas.get(preguntaActualIndex);
        if (preguntaActual.getIdRespuestaCorrecta() == idOpcionSeleccionada) {
            showToast("Correcto!");
            contadorAciertos++; // Incrementa el contador de aciertos
        } else {
            showToast("Incorrecto");
            contadorErrores++; // Incrementa el contador de errores
        }

        // Cambia a la siguiente pregunta
        preguntaActualIndex++;
        if (preguntaActualIndex < preguntas.size()) {
            mostrarPregunta();
        } else {
            showToast("Has completado todas las preguntas.");

        }
    }


    private void showToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}

package com.melaku.reproductor_multimedia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MusicPlayerActivity extends AppCompatActivity {

    private ArrayList<Musica> canciones;
    private MediaPlayer mediaplayer;
    private Runnable runnable;
    private Handler handler = new Handler();
    private int cont = 0, posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        // Crear lista de canciones
        canciones = new ArrayList<>();
        Musica cancion1 = new Musica(R.string.cancion1, R.drawable.portada2, R.raw.mj_smooth_criminal);
        Musica cancion2 = new Musica(R.string.cancion2, R.drawable.led_zeppelin, R.raw.led_zeppelin_whole_lotta_love);
        Musica cancion3 = new Musica(R.string.cancion3, R.drawable.mj_smoothcriminal, R.raw.hoba_hoba_spirit);
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);

        // Recuperamos los datos de la intent
        Intent intent = getIntent();
        posicion = intent.getIntExtra("indice", 0);

        // Inicializar media player con la cancion que nos corresponde
        mediaplayer = MediaPlayer.create(this, canciones.get(posicion).getSonido());


        // Crear un objeto Runnable para sincronizar la barra de progreso con la canción
        runnable = new Runnable() {
            @Override
            public void run() {
                // Sincronizamos la barra con la posición actual de la canción
                ((SeekBar) findViewById(R.id.seekBar)).setProgress(mediaplayer.getCurrentPosition());

                // Programamos una nueva ejecución después de un breve intervalo (500 ms)
                handler.postDelayed(this, 500);
            }
        };

// Obtener la duración total de la canción y formatearla en un string legible
        int duration = mediaplayer.getDuration();
        String sDuracion = convertFormat(duration);

// Configurar la duración máxima de la barra de progreso
        ((SeekBar) findViewById(R.id.seekBar)).setMax(duration);

// Programar la ejecución del Runnable para actualizar la barra de progreso
        handler.postDelayed(runnable, 0);

// Configurar el evento de clic para el botón de reproducción/pausa
        findViewById(R.id.btnIniciar).setOnClickListener(view -> {
            ((SeekBar) findViewById(R.id.seekBar)).setMax(mediaplayer.getDuration());

            // Programar la ejecución del Runnable para actualizar la barra de progreso
            handler.postDelayed(runnable, 0);

            if (cont % 2 == 0) {
                // Pausar la reproducción si está en curso
                mediaplayer.pause();
                findViewById(R.id.btnIniciar).setBackgroundResource(R.drawable.reproducir);
            } else {
                // Iniciar la reproducción si está pausada
                mediaplayer.start();
                findViewById(R.id.btnIniciar).setBackgroundResource(R.drawable.pausa);
            }
            cont++; // Alternar el estado del reproductor (pausa/reproducción)
        });


        findViewById(R.id.btnCancionAlante).setOnClickListener(view -> {
            mediaplayer.stop();
            if (posicion < canciones.size() - 1) {
                posicion++;
                changeMusicFormward();
                mediaplayer.seekTo(0);
            } else {
                posicion = 0;
                changeMusicFormward();
                mediaplayer.seekTo(0);
            }
        });

        findViewById(R.id.bt_pausa).setOnClickListener(view -> {
            mediaplayer.pause();
            // Reiniciar la canción desde el principio
            mediaplayer.seekTo(0);
            ((SeekBar) findViewById(R.id.seekBar)).setMax(mediaplayer.getDuration());
            ((SeekBar) findViewById(R.id.seekBar)).setProgress(0);
            handler.postDelayed(runnable, 0);
            findViewById(R.id.btnIniciar).setBackgroundResource(R.drawable.reproducir);
            cont++;

            // Detener el handler
            handler.removeCallbacks(runnable);
        });

        findViewById(R.id.btnCancionAtras).setOnClickListener(view -> {
            mediaplayer.pause();
            if (posicion == 0) {
                mediaplayer.seekTo(0);
                mediaplayer.start();
            } else {
                posicion--;
                changeMusicFormward();
                mediaplayer.seekTo(0);
            }
        });

// Obtener la referencia a la SeekBar en el diseño
        SeekBar seekBar = findViewById(R.id.seekBar);

// Configurar un listener para la SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Método llamado cuando el progreso de la SeekBar cambia
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Verificar si el cambio fue causado por la interacción del usuario
                if (fromUser) {
                    // Mover la posición de reproducción a la posición actual de la SeekBar
                    mediaplayer.seekTo(progress);
                }

                // Actualizar el progreso de la SeekBar según la posición actual de la canción
                seekBar.setProgress(mediaplayer.getCurrentPosition());

                // Establecer el máximo de la SeekBar como la duración total de la canción
                seekBar.setMax(mediaplayer.getDuration());

                // Actualizar nuevamente el progreso de la SeekBar
                seekBar.setProgress(mediaplayer.getCurrentPosition());
            }

            // Método llamado cuando el usuario comienza a interactuar con la SeekBar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No es necesario realizar acciones específicas al iniciar la interacción
            }

            // Método llamado cuando el usuario deja de interactuar con la SeekBar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No es necesario realizar acciones específicas al dejar de interactuar
            }
        });


        mediaplayer.setOnCompletionListener(mediaPlayer -> {
            mediaPlayer.pause();
            if (posicion < canciones.size() - 1) {
                posicion++;
                changeMusicFormward();
                mediaplayer.seekTo(0);
            } else {
                posicion = 0;
                changeMusicFormward();
                mediaplayer.seekTo(0);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

    private void changeMusicFormward() {
        mediaplayer.release();
        mediaplayer = MediaPlayer.create(this, canciones.get(posicion).getSonido());
        ((SeekBar) findViewById(R.id.seekBar)).setMax(mediaplayer.getDuration());
        handler.postDelayed(runnable, 0);
    }
}

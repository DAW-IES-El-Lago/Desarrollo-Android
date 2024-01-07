package com.melaku.daw.musicplayermelaku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class PlayerActivity extends AppCompatActivity {


        private MediaPlayer mediaPlayer;
        private SeekBar seekBar;
        private TextView txtSongStart;
        private TextView txtSongEnd;
        private Button btnPlay;
        private Handler handler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_reproductor);

            mediaPlayer = MediaPlayer.create(this, R.raw.sample_song); // Reemplaza con mis canciones nuevas
            seekBar = findViewById(R.id.SeekBar);
            txtSongStart = findViewById(R.id.TxtSongStart);
            txtSongEnd = findViewById(R.id.TxtSongEnd);
            btnPlay = findViewById(R.id.BtnPlay);

            handler = new Handler();

            updateSeekBar();
        }

    public void onPlayPauseClick(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            btnPlay.setBackgroundResource(R.drawable.play_song_icon); //esto por ahora es texto fijo pero hay que buscar iconos
        } else {
            mediaPlayer.start();
            btnPlay.setBackgroundResource(R.drawable.pause_song_icon);
        }
    }

    //hay que iterar en una lista de canciones o retroceder y logica para evitar rebasar limites
    public void onNextClick(View view) {
        // Lógica para reproducir la siguiente canción
    }

    public void onPreviousClick(View view) {
        // Lógica para reproducir la canción anterior
    }


    //esto es copiado entero solo sirve para la barra de progreso de la cancion
    //abre un nuevo hilo de ejecución para ir mostrando el progreso
    private void updateSeekBar() {
        seekBar.setMax(mediaPlayer.getDuration());

        mediaPlayer.setOnPreparedListener(mp -> {
            int duration = mp.getDuration();
            txtSongEnd.setText(formatTime(duration));
        });

        new Thread(() -> {
            while (mediaPlayer != null) {
                try {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(currentPosition);

                    runOnUiThread(() -> txtSongStart.setText(formatTime(currentPosition)));

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
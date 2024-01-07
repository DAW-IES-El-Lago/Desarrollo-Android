package com.melaku.reproductor_multimedia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abre la lista de libros -- metodo openReading mas abajo
        findViewById(R.id.btn_1).setOnClickListener(this::openReading);

        //Abre el video player
        findViewById(R.id.btn_2).setOnClickListener(view -> {
            Intent i = new Intent(this, VideoPlayerActivity.class);
            startActivity(i);
        });

        //Abre el reproductor musical directamente
        findViewById(R.id.btn_3).setOnClickListener(view -> {
            Intent i = new Intent(this, MusicPlayerActivity.class);
            startActivity(i);
        });

        //Abre la lista de canciones
        findViewById(R.id.btn_4).setOnClickListener(view -> {
            Intent i = new Intent(this, SongsListActivity.class);
            startActivity(i);
        });
    }

    //Esto lo he implementado con un metodo por variar un poco pero abre la lista de libros
    public void openReading(View view){
        try {
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        } catch (Exception e){
            Log.e("CardView", "Error: " + e.getMessage());
        }
    }
}

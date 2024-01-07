package com.melaku.reproductor_multimedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class SongsListActivity extends AppCompatActivity {
    private ArrayList<String> listaCancion;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);

        //Toolbar
        setSupportActionBar(findViewById(R.id.toolbar4));
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listaCancion = new ArrayList<>();
        listaCancion.add("HOBA HOBA SPIRIT WALKE CHAREB");
        listaCancion.add("Led Zeppelin - Whole Lotta Love");
        listaCancion.add("Michael Jackson - Smooth Criminal");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCancion);
        listView = findViewById(R.id.listacanciones);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SongsListActivity.this, listaCancion.get(position), Toast.LENGTH_LONG).show();
                Intent i = new Intent(SongsListActivity.this, MusicPlayerActivity.class);
                i.putExtra("indice", position);
                startActivityForResult(i, 0);
            }
        });
    }
}

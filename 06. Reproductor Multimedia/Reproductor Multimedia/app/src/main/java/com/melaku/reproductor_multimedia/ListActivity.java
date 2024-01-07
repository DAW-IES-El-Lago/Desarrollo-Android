package com.melaku.reproductor_multimedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import io.github.muddz.styleabletoast.StyleableToast;

public class ListActivity extends AppCompatActivity {
    private ArrayList<String> listaLibros;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Toolbar
        setSupportActionBar(findViewById(R.id.toolbarAcividad2));
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listaLibros = new ArrayList<>();
        listaLibros.add("Libro 1");
        listaLibros.add("Libro 2");
        listaLibros.add("Libro 3");
        listaLibros.add("Libro 4");
        listaLibros.add("Libro 5");
        listaLibros.add("Libro 6");
        listaLibros.add("Libro 7");
        listaLibros.add("Libro 8");
        listaLibros.add("Libro 9");
        listaLibros.add("Libro 10");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLibros);

        listView = findViewById(R.id.lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Muestra el texto original del Toast
                //.makeText(ListActivity.this, listaLibros.get(position), Toast.LENGTH_LONG).show();

                // Crea y muestra el StyleableToast
                StyleableToast.makeText(ListActivity.this, listaLibros.get(position), Toast.LENGTH_LONG, R.style.MyToast).show();
            }
        });

    }
}

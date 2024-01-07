package com.melaku.daw.musicplayermelaku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning Address of the Android Materials
        listView = findViewById(R.id.ListView);

        // Displaying songs from resources
        displaySong();
    }

    public void displaySong() {
        // Dummy list of songs from resources
        ArrayList<String> mySongs = new ArrayList<>();
        mySongs.add("Song 1");
        mySongs.add("Song 2");
        mySongs.add("Song 3");

        items = new String[mySongs.size()];

        // Adding all the music file names to the array
        for (int i = 0; i < mySongs.size(); i++) {
            items[i] = mySongs.get(i);
        }

        // Calling the adapter and setting it to ListView
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        // Implementing onClickListener for ListView
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String songName = (String) listView.getItemAtPosition(i);

            // Calling the next intent and sending the Required Details to play the songs
            Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
            intent.putExtra("songs", mySongs);
            intent.putExtra("songname", songName);
            intent.putExtra("pos", i);
            startActivity(intent);
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // Returning the count of total songs in an ArrayList
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Inflating all the single music files in a Layout File
            View view = getLayoutInflater().inflate(R.layout.song_name_layout, null);
            TextView txtSong = view.findViewById(R.id.SongName);
            txtSong.setSelected(true);
            txtSong.setText(items[position]);
            return view;
        }
    }
}

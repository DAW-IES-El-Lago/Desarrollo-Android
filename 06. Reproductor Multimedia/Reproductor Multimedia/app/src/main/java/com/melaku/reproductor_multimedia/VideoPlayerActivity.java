package com.melaku.reproductor_multimedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        VideoView VideoPlayerContainerUI = findViewById(R.id.VideoPlayerContainerUI);


        Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.animalesmarinos3);
        VideoPlayerContainerUI.setVideoURI(path);

        setSupportActionBar(findViewById(R.id.toolbar3));
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        MediaController mediaController = new MediaController(this);

        VideoPlayerContainerUI.setMediaController(mediaController);
        VideoPlayerContainerUI.start();
    }
}

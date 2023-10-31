package com.melaku.daw.actividadesmultiples;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setAlarmButton = findViewById(R.id.set_alarm_button);

        setAlarmButton.setOnClickListener(v -> {
            Intent openClockIntent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "¡Despierta Putoooo!")
                    .putExtra(AlarmClock.EXTRA_HOUR, 6)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 5)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

            if (openClockIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openClockIntent);
            }
        });

    }
}


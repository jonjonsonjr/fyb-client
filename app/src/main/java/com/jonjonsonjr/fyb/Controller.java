package com.jonjonsonjr.fyb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ResourceBundle;

public class Controller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        Button b = (Button) findViewById(R.id.logout);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                sharedPreferences.edit().putBoolean(Preferences.SENT_TOKEN, false).commit();

                // We already registered
                Intent controller = new Intent(Controller.this, MainActivity.class);
                startActivity(controller);
            }
        });
    }
}

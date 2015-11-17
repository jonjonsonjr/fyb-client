package com.jonjonsonjr.fyb;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;

public class SpeakService extends Service implements TextToSpeech.OnInitListener {

    private static final String TAG = "SpeakService";
    private TextToSpeech tts;

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Log.d(TAG, "Success");
        } else {
            Log.d(TAG, "Could not initialize TextToSpeech.");
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (tts != null) {
            String message = intent.getStringExtra("message");
            tts.speak(message, TextToSpeech.QUEUE_ADD, null, "foo");
        }

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");

        tts = new TextToSpeech(this, this);

        super.onCreate();
    }


    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }
}

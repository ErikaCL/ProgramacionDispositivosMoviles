package com.example.activity04;

import android.util.Log;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Creada...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Iniciada...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Reanudada...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Pausada...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Parada...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: Reiniciada...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Destruida...");
    }

}
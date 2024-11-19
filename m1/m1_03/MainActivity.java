package com.example.activity01;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numeros = new int[1_000_000];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(1_000_000);  
        }

        long tiempoInicio = System.currentTimeMillis();

        // Ordenar el arreglo
        Arrays.sort(numeros);

        long tiempoFin = System.currentTimeMillis();

        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        // Imprimir el tiempo de ejecución en el logcat
        Log.d("MainActivity", "Tiempo Total de Ejecución (en milisegundos): " + tiempoTranscurrido);
    }
}

package com.example.activity01;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear un arreglo de 1 millón de elementos enteros aleatorios
        int[] numeros = new int[1_000_000];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(1_000_000);  // Rango de 0 a 999999
        }

        // Medir el tiempo de inicio
        long tiempoInicio = System.currentTimeMillis();

        // Ordenar el arreglo
        Arrays.sort(numeros);

        // Medir el tiempo de fin
        long tiempoFin = System.currentTimeMillis();

        // Calcular el tiempo transcurrido
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        // Imprimir el tiempo de ejecución en el logcat
        Log.d(TAG, "Tiempo de ejecución en milisegundos: " + tiempoTranscurrido);
    }
}

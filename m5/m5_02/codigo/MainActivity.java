package com.example.activity05_02;

import android.util.Log;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "¿Cuántas calorías totales lleva ese elfo?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int calsTotales = getMaxCaloriasTotales("input.txt");
        Log.i(TAG, "El elfo con más calorías totales lleva: " + calsTotales + " totales");
    }

    private int getMaxCaloriasTotales(String fileName) {

        ArrayList<Integer> calorias = new ArrayList<>();

        int suma = 0;

        try {

            InputStream inputStream = getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linea;

            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty()) {
                    calorias.add(suma);
                    suma = 0;
                } else {
                    suma += Integer.parseInt(linea);
                }

            }

            if (suma != 0) {
                calorias.add(suma);
            }

            reader.close();

        } catch (IOException e) {
            Log.e(TAG, "Error al leer el archivo", e);
        }

        int maxSuma = 0;
        for (int sum : calorias) {
            if (sum > maxSuma) {
                maxSuma = sum;
            }
        }

        return maxSuma;
    }
}

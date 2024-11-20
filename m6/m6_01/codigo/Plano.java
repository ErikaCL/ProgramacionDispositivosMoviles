package com.example.activity_06;

import android.graphics.Point;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

public class Plano {
    int col, row, paso;
    ArrayList<Avion> aviones;
    ArrayList<Point> colisiones;
    ArrayList<ArrayList<Avion>> historial; // Para retroceder

    public Plano(int col, int row) {
        this.col = col;
        this.row = row;
        this.paso = 0;
        this.aviones = new ArrayList<>();
        this.colisiones = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public void agregarAvion(int x, int y, String direccion) {
        aviones.add(new Avion(x, y, direccion));
    }

    public void moverAviones() {
        historial.add(new ArrayList<>(aviones));
        HashMap<String, Avion> posiciones = new HashMap<>();
        colisiones.clear();

        for (Avion avion : aviones) {
            avion.mover();
            String key = avion.x + "," + avion.y;

            if (posiciones.containsKey(key)) {
                colisiones.add(new Point(avion.x, avion.y));
            } else {
                posiciones.put(key, avion);
            }
        }

        Log.d("Plano", "Paso: " + paso++);
        Log.d("Plano", "Aviones: " + aviones.size());
        Log.d("Plano", "Colisiones detectadas: " + colisiones.size());
    }

    public void retroceder() {
        if (!historial.isEmpty()) {
            aviones = historial.remove(historial.size() - 1);
            paso--;
            Log.d("Plano", "Retrocediendo al paso: " + paso);
        } else {
            Log.d("Plano", "No hay pasos anteriores para retroceder.");
        }
    }
}

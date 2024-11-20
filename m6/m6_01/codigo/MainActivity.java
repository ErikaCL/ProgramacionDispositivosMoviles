package com.example.activity_06;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNext, btnPrev;
    RecyclerView listaAviones;
    Plano plano;
    AvionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        listaAviones = findViewById(R.id.listaAviones);

        // Crea plano inicial
        plano = new Plano(5, 5);
        plano.agregarAvion(0, 0, "EAST");
        plano.agregarAvion(2, 0, "WEST");

        adapter = new AvionAdapter(plano);
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new GridLayoutManager(this, plano.col));

        btnNext.setOnClickListener(v -> {
            plano.moverAviones();
            adapter.notifyDataSetChanged();
        });

        btnPrev.setOnClickListener(v -> {
            plano.retroceder();
            adapter.notifyDataSetChanged();
        });
    }
}

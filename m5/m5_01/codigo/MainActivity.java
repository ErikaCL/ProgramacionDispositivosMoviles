package com.example.activity05_01;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFibonacci;
    private Button buttonAvanzar, buttonRetroceder;

    private int currentIndex = 1;

    private HashMap<Integer, Integer> memoizationMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFibonacci = findViewById(R.id.textViewFibonacci);
        buttonAvanzar = findViewById(R.id.buttonAvanzar);
        buttonRetroceder = findViewById(R.id.buttonRetroceder);

        textViewFibonacci.setText(String.valueOf(fibonacci(currentIndex)));

        buttonAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                textViewFibonacci.setText(String.valueOf(fibonacci(currentIndex)));
            }
        });

        buttonRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 1) {
                    currentIndex--;
                    textViewFibonacci.setText(String.valueOf(fibonacci(currentIndex)));
                }
            }
        });

    }

    private int fibonacci(int i) {
        if (i <= 1) {
            return i;
        }

        if (memoizationMap.containsKey(i)) {
            return memoizationMap.get(i);
        }

        int result = fibonacci(i - 1) + fibonacci(i - 2);
        memoizationMap.put(i, result);

        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}


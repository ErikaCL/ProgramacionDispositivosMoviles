package com.example.activity03;

import android.util.Log;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Control control = new Control();

        control.introduceValorX(10);
        control.introduceValorY(5);
        control.introduceOperacion(Operacion.MUL);

        Calculadora calculadora = new Calculadora();
        calculadora.setControl(control);

        float resultado = calculadora.calcularResultado();

        Log.i("Calculadora", "El resultado es: " + resultado);
    }
}

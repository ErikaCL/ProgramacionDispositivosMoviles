package com.example.activity03;

public class Calculadora implements ICalculadora{

    private IControl control;

    @Override
    public void setControl(IControl control){
        this.control = control;
    }

    public float calcularResultado(){
        if(control == null){
            throw new IllegalStateException("Control no configurado en la calculadora.");
        }

        return control.igual();
    }

}

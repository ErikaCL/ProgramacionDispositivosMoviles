package com.example.activity03;

public class Control implements IControl
{
    private int x;
    private int y;
    private Operacion operacion;

    @Override
    public void introduceValorX(int x){
        this.x = x;
    }

    @Override
    public void introduceValorY(int y){
        this.y = y;
    }

    @Override
    public void introduceOperacion(Operacion op) {
        this.operacion = op;
    }

    @Override
    public float igual() {
        float resultado = 0;

        if (operacion != null) {
            switch (operacion) {
                case SUM:
                    resultado = x + y;
                    break;
                case RES:
                    resultado = x - y;
                    break;
                case MUL:
                    resultado = x * y;
                    break;
                case DIV:
                    if (y != 0) {
                        resultado = (float) x / y;
                    } else {
                        throw new ArithmeticException("División por cero no permitida.");
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Operación no soportada.");
            }
        } else {
            throw new IllegalStateException("No se ha especificado ninguna operación.");
        }

        return resultado;
        }
    }


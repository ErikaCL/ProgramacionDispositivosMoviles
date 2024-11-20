package com.example.activity_06;

public class Avion {
    int x, y;
    String direccion;

    public Avion(int x, int y, String direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }

    public void mover() {
        switch (direccion) {
            case "NORTH":
                y--;
                break;
            case "SOUTH":
                y++;
                break;
            case "EAST":
                x++;
                break;
            case "WEST":
                x--;
                break;
        }
    }

    public int getImage() {
        switch (direccion) {
            case "NORTH":
                return R.mipmap.north;
            case "SOUTH":
                return R.mipmap.south;
            case "EAST":
                return R.mipmap.east;
            case "WEST":
                return R.mipmap.west;
        }
        return 0;
    }
}

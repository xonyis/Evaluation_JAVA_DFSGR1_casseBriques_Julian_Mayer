package models;

import java.awt.*;

public class Brique extends Rectangle{
    public Brique(int x, int y, Color couleur, int width, int height) {
        super(x, y, couleur, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

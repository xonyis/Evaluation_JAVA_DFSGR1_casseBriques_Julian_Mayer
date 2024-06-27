package models;

import java.awt.*;

public class Rectangle extends Sprite{

    protected int width;

    protected int height;

    public Rectangle(int x, int y, Color couleur, int width, int height) {
        super(x, y, couleur);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillRect(x, y, width, height);
    }
}

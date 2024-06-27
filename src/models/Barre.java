package models;

import application.Fenetre;

import java.awt.*;

public class Barre extends Rectangle{

    private static final int SPEED = 10;

    protected int largeur;
    protected int hauteur;

//    public Barre(int x, int y, int largeur, int hauteur, Color couleur) {
//        super(x, y, couleur);
//        this.largeur = largeur;
//        this.hauteur = hauteur;
//    }

    public Barre() {
        super(Fenetre.LARGEUR / 2 - 75, Fenetre.HAUTEUR - 100, Color.BLUE, 50,50);
        this.largeur = 150;
        this.hauteur = 20;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x,y,largeur,hauteur);
    }

    public void moveLeft() {
        x = Math.max(0, x - SPEED);
    }

    public void moveRight() {
        x = Math.min(Fenetre.LARGEUR - largeur, x + SPEED);
    }

    public int getX() {
        return x;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getY() {
        return y;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}

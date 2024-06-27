package models;

import application.Fenetre;

import java.awt.*;
import java.util.List;

public class Balle extends Sprite{

    protected int vitesseX = 10;
    protected int vitesseY = 10;
    protected int diametre = 50;

    public Balle(int x, int y, Color couleur, int diametre) {
        super(x, y , couleur);
        this.diametre = diametre;
    }

    public Balle(int x, int y, int vitesseX, int vitesseY) {
        super(x,y,Color.RED);
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
    }

    public Balle(int x, int y) {
        super(x,y,Color.RED);
        this.vitesseX = 5;
        this.vitesseY = 5;
    }

    public void deplacement(Barre barre, List<Brique> briques ) {

        if(x > Fenetre.LARGEUR - diametre || x < 0) {
            vitesseX = - vitesseX;
        }
        if(y<0){
            vitesseY = -vitesseY;
        }

        if(y > Fenetre.HAUTEUR - diametre) {
            vitesseY = - vitesseY;
        }

//        Détecte les collisions
        if (y + diametre >= barre.getY() && y <= barre.getY() + barre.getHauteur()&&
                x + diametre >= barre.getX() && x <= barre.getX() + barre.getLargeur()) {
            vitesseY = -vitesseY;
            y = barre.getY() - diametre;
        }

        for (int i = 0; i < briques.size(); i++) {
            Brique brique = briques.get(i);
            if (this.colisions(brique)) {
                System.out.println(i);
                briques.remove(i); // Remove the brick
                vitesseY = -vitesseY;
                break;
            }
        }
//          ----------------------
        x += vitesseX;
        y += vitesseY;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
    }

    private boolean colisions(Brique brique) {
        return x + diametre >= brique.getX() && x <= brique.getX() + brique.getWidth() &&
                y + diametre >= brique.getY() && y <= brique.getY() + brique.getHeight();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }
}

package application;

import models.Balle;
import models.Barre;
import models.Brique;
import models.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Fenetre extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 700;

    protected boolean toucheEspace = false;
    protected boolean left = false;
    protected boolean right = false;

    ArrayList<Brique> arrayBriques = new ArrayList<>();


    ArrayList<Balle> arrayBalles = new ArrayList<>();
    ArrayList<Sprite> arraySprites = new ArrayList<>();
    Barre barre;

    Fenetre()  throws InterruptedException {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0, 0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR, HAUTEUR );
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);


        Container panneau = fenetre.getContentPane();
        panneau.add(this);

        fenetre.setVisible(true);
        this.createBufferStrategy(2);



        this.demarrer();
    }

    public void demarrer() throws InterruptedException {

        barre = new Barre();
        arraySprites.add(barre);

        // ajout de la balle
        Balle balle = new Balle(100, 200 , Color.GREEN, 30);
        arrayBalles.add(balle);
        arraySprites.add(balle);

//           tableau de briques
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                Brique brique = new Brique(15 +( j * 60), 10 + i * 30, Color.RED,50, 20);
                arrayBriques.add(brique);
                arraySprites.add(brique);
            }
        }

        while(true) {

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,LARGEUR,HAUTEUR);

            // déplacement balle
            for(Balle b : arrayBalles) {
                b.deplacement(barre, arrayBriques);
            }
//            dessine les sprites de l'app
            List<Sprite> spritesToDraw = new ArrayList<>(arraySprites);
            for (Sprite s : spritesToDraw) {
                if (s instanceof Brique && !arrayBriques.contains(s)) {
                    continue;
                }
                s.dessiner(dessin);
            }
//            Ne sert pas
//            if(toucheEspace) {
//                arrayBalles.add( new Balle(200, 400 , Color.BLUE, 50));
//            }
//            deplacement de la barre via les touches
            if (left) {
                barre.moveLeft();
            }
            if (right) {
                barre.moveRight();
            }

            if (balle.getY() <= 0 || balle.getY() >= 650 )
            {
                balle.setVitesseX(0);
                balle.setVitesseY(0);
            }

            dessin.dispose();
            this.getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            toucheEspace = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void  keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            toucheEspace = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}

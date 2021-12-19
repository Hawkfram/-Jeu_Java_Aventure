package com.example.canvas;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Case extends Parent {

    private final int emplacementx;
    private final int emplacementy;
    private SimpleDoubleProperty hauteur;
    private SimpleDoubleProperty largeur;
    private Image blocTerre;
    private Image personnage;
    private Image pierre;
    private Image bois;
    private Image caisse;
    private Image arriver;
    private ImageView iV;

    public Case(int x, int y) {
        emplacementx = x;
        emplacementy = y;

        hauteur = new SimpleDoubleProperty();
        largeur = new SimpleDoubleProperty();
        hauteur.set(12);
        largeur.set(12);
        largeur.bind(hauteur);

        //fond
        blocTerre = new Image("file:terre.jpeg");
        personnage = new Image("file:pers.jpeg");
        pierre = new Image("file:pierre.jpeg");
        bois = new Image("file:bois.jpeg");
        caisse = new Image("file:caisse.jpeg");
        arriver = new Image("file:arriver.png");

        iV = new ImageView(blocTerre);
        iV.setFitWidth(12);
        iV.setFitHeight(12);

        iV.fitHeightProperty().bind(hauteur);
        iV.fitWidthProperty().bind(largeur);
        this.getChildren().add(iV);
    }

    public SimpleDoubleProperty getHauteur() {
        return hauteur;
    }

    public SimpleDoubleProperty getLargeur() {
        return largeur;
    }

    public int getEmplacementx() {
        return emplacementx;
    }

    public int getEmplacementy() {
        return emplacementy;
    }

    public void set(int type){
        if(type==0){
            iV.setImage(blocTerre);
        }
        else if(type==1){
            iV.setImage(pierre);
        }
        else if(type==2){
            iV.setImage(caisse);
        }
        else if(type==3){
            iV.setImage(bois);
        }
        else if(type==4){
            iV.setImage(arriver);
        }
        else if(type==8){
            iV.setImage(personnage);
        }
    }

    public int get(){
        if(iV.getImage().equals(pierre)){
            return 1;
        }else if(iV.getImage().equals(bois)) {
            return 3;
        }else if(iV.getImage().equals(arriver)) {
            return 4;
        }else if(iV.getImage().equals(caisse)){
            return 2;
        }else if(iV.getImage().equals(personnage)){
            return 8;
        }
        return 0;
    }
}

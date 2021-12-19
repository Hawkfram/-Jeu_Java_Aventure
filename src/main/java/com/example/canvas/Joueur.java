package com.example.canvas;

public class Joueur {

    private int positionX;
    private int positionY;
    private int vie;
    private int niveau;

    public Joueur(int axeX,int axeY){
        positionX=axeX;
        positionY=axeY;

        vie=3;
        niveau=1;
    }

    public void setPosition(int axeX,int axeY){
        positionX=axeX;
        positionY=axeY;
    }

    public void setVie(int changement){
        this.vie+=changement;
    }

    public void setNiveau(int changement){
        this.niveau+=changement;
    }

    public int getPositionX(){
        return positionX;
    }

    public int getPositionY(){
        return positionY;
    }

    public int getVie() {
        return vie;
    }

    public int getNiveau() {
        return niveau;
    }
}

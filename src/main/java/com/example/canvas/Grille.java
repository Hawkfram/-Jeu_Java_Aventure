package com.example.canvas;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Grille extends Parent {

    private final Case[][] plateauTab;
    private final int colonnes;
    private final int lignes;
    private Joueur j1;
    List<Integer> axeX = new ArrayList<>();
    List<Integer> axeY = new ArrayList<>();
    List<Integer> type = new ArrayList<>();

    public Grille(int colonne, int lignes, Scene scene,GridPane plateau){

        plateauTab = new Case[colonne][lignes];
        this.colonnes = colonne;
        this.lignes = lignes;

        for(int i=0; i<colonne ; i++){
            for(int n=0; n<lignes ; n++){
                plateauTab[i][n] = new Case(i,n);
                plateau.add(plateauTab[i][n],i,n);
                plateauTab[i][n].getHauteur().bind(scene.heightProperty().subtract(100).divide(40));
                plateauTab[i][n].getLargeur().bind(scene.widthProperty().subtract(60).divide(40));
                if(i==0 || i==colonne-1 || n==0 || n==lignes-1){
                    plateauTab[i][n].set(1);
                }
            }
        }
    }

    public void departJoueur(){
        j1 = new Joueur(21,10);
        plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
    }

    public void arriverJoueur(int axeX,int axeY){
        plateauTab[axeX][axeY].set(4);
    }

    public void mouvementJoueur(String touche){
        if(Objects.equals(touche, "LEFT")){
            if(plateauTab[j1.getPositionX()-1][j1.getPositionY()].get()==0){
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                j1.setPosition(j1.getPositionX()-1, j1.getPositionY());
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
            }else if(plateauTab[j1.getPositionX()-1][j1.getPositionY()].get()==4){
                System.out.println("Arriver au niveau "+j1.getNiveau());
                j1.setNiveau(1);
            }else if(plateauTab[j1.getPositionX()-1][j1.getPositionY()].get()==2){

                if(plateauTab[j1.getPositionX()-2][j1.getPositionY()].get()==0){
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                    j1.setPosition(j1.getPositionX()-1, j1.getPositionY());
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
                    plateauTab[j1.getPositionX()-1][j1.getPositionY()].set(2);
                }

            }
        }else if(Objects.equals(touche, "RIGHT")){
            if(plateauTab[j1.getPositionX()+1][j1.getPositionY()].get()==0){
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                j1.setPosition(j1.getPositionX()+1, j1.getPositionY());
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
            }else if(plateauTab[j1.getPositionX()+1][j1.getPositionY()].get()==4){
                System.out.println("Arriver au niveau "+j1.getNiveau());
                j1.setNiveau(1);
            }else if(plateauTab[j1.getPositionX()+1][j1.getPositionY()].get()==2){

                if(plateauTab[j1.getPositionX()+2][j1.getPositionY()].get()==0){
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                    j1.setPosition(j1.getPositionX()+1, j1.getPositionY());
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
                    plateauTab[j1.getPositionX()+1][j1.getPositionY()].set(2);
                }

            }
        }else if(Objects.equals(touche, "UP")){
            if(plateauTab[j1.getPositionX()][j1.getPositionY()-1].get()==0){
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                j1.setPosition(j1.getPositionX(), j1.getPositionY()-1);
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
            }else if(plateauTab[j1.getPositionX()][j1.getPositionY()-1].get()==4){
                System.out.println("Arriver au niveau "+j1.getNiveau());
                j1.setNiveau(1);
            }else if(plateauTab[j1.getPositionX()][j1.getPositionY()-1].get()==2){

                if(plateauTab[j1.getPositionX()][j1.getPositionY()-2].get()==0){
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                    j1.setPosition(j1.getPositionX(), j1.getPositionY()-1);
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
                    plateauTab[j1.getPositionX()][j1.getPositionY()-1].set(2);
                }

            }
        }else if(Objects.equals(touche, "DOWN")){
            if(plateauTab[j1.getPositionX()][j1.getPositionY()+1].get()==0){
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                j1.setPosition(j1.getPositionX(), j1.getPositionY()+1);
                plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
            }else if(plateauTab[j1.getPositionX()][j1.getPositionY()+1].get()==4){
                j1.setNiveau(1);
                System.out.println("Arriver au niveau "+j1.getNiveau());
                creationMap(j1.getNiveau());
            }else if(plateauTab[j1.getPositionX()][j1.getPositionY()+1].get()==2){

                if(plateauTab[j1.getPositionX()][j1.getPositionY()+2].get()==0){
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(0);
                    j1.setPosition(j1.getPositionX(), j1.getPositionY()+1);
                    plateauTab[j1.getPositionX()][j1.getPositionY()].set(8);
                    plateauTab[j1.getPositionX()][j1.getPositionY()+1].set(2);
                }

            }
        }
    }

    public void creationMap(int niveau){

        switch (niveau){
            case 1:
                renitialiserCarte();
                departJoueur();
                arriverJoueur(20,39);
                //On initialise les obstacles de la carte
                Collections.addAll(axeX,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2);
                Collections.addAll(axeY,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
                Collections.addAll(type,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2);

                if(axeX.size()!=axeY.size()){

                    System.out.println("================================================");
                    System.out.println("ERREUR : problème dans la création de la map tout\n les obstacle non pas de coordonées X et Y");
                    System.out.println("================================================");

                }

                for(int i=0;i<axeX.size();i++){

                    plateauTab[axeX.get(i)][axeY.get(i)].set(type.get(i));

                }

                break;
            case 2:
                renitialiserCarte();
                departJoueur();
                arriverJoueur(20,39);
                Collections.addAll(axeX,2,3,4);
                Collections.addAll(axeY,4,4,4);
                Collections.addAll(type,3,3,3);

                if(axeX.size()!=axeY.size()){

                    System.out.println("================================================");
                    System.out.println("ERREUR : problème dans la création de la map tout\n les obstacle non pas de coordonées X et Y");
                    System.out.println("================================================");

                }
                for(int i=0;i<axeX.size();i++){
                    plateauTab[axeX.get(i)][axeY.get(i)].set(type.get(i));
                }

                break;
            default:

                System.out.println("================================================");
                System.out.println("ERREUR : ce niveau n'existe pas encore ou n'est pas valide");
                System.out.println("================================================");

        }
    }

    public void renitialiserCarte(){
        for(int i=0; i<colonnes ; i++){
            for(int n=0; n<lignes ; n++){
                if(i==0 || i==colonnes-1 || n==0 || n==lignes-1){
                    plateauTab[i][n].set(1);
                }else{
                    plateauTab[i][n].set(0);
                }
            }
        }
        axeY.clear();
        axeX.clear();
        type.clear();
    }

}
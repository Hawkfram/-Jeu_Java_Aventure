package com.example.canvas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        Scene scene = new Scene(root,600,600+100);
        Grille carte;

        //Couleur fond
        Color couleurFond = Color.BLACK;

        //Fond
        scene.setFill(couleurFond);

        //Plateau
        GridPane plateau = new GridPane();
        plateau.setHgap(1);
        plateau.setVgap(1);
        root.getChildren().add(plateau);

        carte = new Grille(40,40,scene,plateau);

        carte.creationMap(1);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                String touche = ke.getCode().toString();
                carte.mouvementJoueur(touche);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class week8Ex extends Application {
    final static int screenWidth = 800;
    final static int screenHeight = 600;

    public void start(Stage stage) throws Exception{

        Pane mainLayout = new Pane();

        Button btnTroll = new Button("!!click me if you can!!");

        mainLayout.getChildren().addAll(btnTroll);

        btnTroll.setOnMouseEntered((MouseEvent e) -> {
            setNewPos(btnTroll);
        });

        btnTroll.setOnMouseClicked((MouseEvent e) ->{
            System.out.println("clicked");
        });

        Scene scene = new Scene(mainLayout, screenWidth, screenHeight);

        stage.setTitle("Try to click me!!");
        stage.setScene(scene);
        stage.show();

    }

    public static void setNewPos(Button btnTroll) {
        double x = (Math.random() * (screenWidth-btnTroll.getWidth()));
        double y = (Math.random() * (screenHeight-btnTroll.getHeight()));

        btnTroll.setLayoutX(x);
        btnTroll.setLayoutY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

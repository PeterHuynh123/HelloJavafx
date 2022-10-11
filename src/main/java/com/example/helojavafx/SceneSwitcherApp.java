package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SceneSwitcherApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Main layout
        VBox mainLayout = new VBox();

        // scene 1
        Rectangle square = new Rectangle();
        square.setX(200.0f);
        square.setY(200.0f);
        square.setWidth(162.0f);
        square.setHeight(162.0f);
        square.setFill(Color.RED);

        // scene2
        ImageView imageView = new ImageView("https://www.mobafire.com/images/champion/square/zed.png");

        HBox buttonsContainer = new HBox();
        Button btn1 = new Button("Scene 1");
        Button btn2 = new Button("Scene 2");

        btn1.setOnAction((ActionEvent e) -> {
//            buttonClickHandler(mainLayout, square);
            mainLayout.getChildren().set(0, square);
        });

        btn2.setOnAction((ActionEvent e) -> {
            buttonClickHandler(mainLayout, imageView);
        });

        buttonsContainer.getChildren().addAll(btn1, btn2);

        mainLayout.getChildren().addAll(square, buttonsContainer);

        Scene mainScene = new Scene(mainLayout, 500, 500);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void buttonClickHandler(VBox mainLayout, Node replacingNode) {
        mainLayout.getChildren().set(0, replacingNode);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
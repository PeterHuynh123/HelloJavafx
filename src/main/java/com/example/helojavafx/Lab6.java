package com.example.helojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lab6 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane bgPane = new Pane();

        bgPane.setStyle("-fx-background-color: #37b0ae;");


        GridPane EX1GridPane = new GridPane();

        ImageView flag1 = new ImageView("https://cdn.britannica.com/41/4041-004-D051B135/Flag-Vietnam.jpg");
        ImageView flag2 = new ImageView("https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png");
        ImageView flag3 = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Flag_of_Singapore.svg/1200px-Flag_of_Singapore.svg.png");
        ImageView flag4 = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1024px-Flag_of_the_People%27s_Republic_of_China.svg.png");

        flag1.setPreserveRatio(true);
        flag2.setPreserveRatio(true);
        flag3.setPreserveRatio(true);
        flag4.setPreserveRatio(true);

        flag1.setFitWidth(400);
        flag2.setFitWidth(400);
        flag3.setFitWidth(400);
        flag4.setFitWidth(400);

        EX1GridPane.setVgap(5.0);
        EX1GridPane.setHgap(5.0);



        EX1GridPane.add(flag1, 0,0);
        EX1GridPane.add(flag2, 1,0);
        EX1GridPane.add(flag3, 0,1);
        EX1GridPane.add(flag4, 1,1);

        StackPane EX1MainLayout = new StackPane();

        EX1MainLayout.getChildren().addAll(bgPane, EX1GridPane);

        Scene sceneEX1 = new Scene(EX1MainLayout, 800, 800);

        primaryStage.setScene(sceneEX1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

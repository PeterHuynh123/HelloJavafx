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

public class JavaAppSceneSwitcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainLayout = new VBox();

        Rectangle scene1 = new Rectangle();
        scene1.setX(400.0f);
        scene1.setY(400.0f);
        scene1.setWidth(324.0f);
        scene1.setHeight(324.0f);
        scene1.setFill(Color.web("#3291a8"));

        ImageView scene2 = new ImageView("https://product.hstatic.net/1000026716/product/gearvn-chuot-logitech-g-pro-wireless-1_d55861073737476eac32b63315542f31.png");

        scene2.setX(324.0);
        scene2.setY(324.0);

        HBox btnsLayout = new HBox();

        Button btnScene1 = new Button("Scene 1");
        Button btnScene2 = new Button("Scene 2");

        btnScene1.setOnAction((ActionEvent e) -> {
//            buttonClickHandler(mainLayout, square);
            mainLayout.getChildren().set(0, scene1);
        });

        btnScene2.setOnAction((ActionEvent e) -> {
            buttonClickHandler(mainLayout, scene2);
        });

        btnsLayout.getChildren().addAll(btnScene1, btnScene2);

        mainLayout.getChildren().addAll(scene2, btnsLayout);

        Scene scene = new Scene(mainLayout, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void buttonClickHandler(VBox mainLayout, Node replacingNode) {
        mainLayout.getChildren().set(0, replacingNode);
    }
}

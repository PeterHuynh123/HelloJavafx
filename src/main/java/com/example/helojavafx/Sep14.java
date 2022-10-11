package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sep14 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Click me");

        Label lb1 = new Label("Label");


        btn1.setOnAction((ActionEvent e) -> {
            System.out.println("btn clicked");
        });

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked");
            }
        };

        EventHandler<MouseEvent> mouseHover = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hovering");
//                lb1.setText("mouse is hovering");
                lb1.setTextFill(Color.web("#fcba03"));
            }
        };

        EventHandler<MouseEvent> mouseExit = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse exited");
//                lb1.setText("mouse is hovering");
                lb1.setTextFill(Color.web("#000000"));
            }
        };


        lb1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        lb1.addEventFilter(MouseEvent.MOUSE_ENTERED, mouseHover);
        lb1.addEventFilter(MouseEvent.MOUSE_EXITED, mouseExit);

        VBox layout = new VBox(btn1, lb1);

        Scene scene = new Scene(layout, 800, 800);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Oct22_eventHandler extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        VBox vbox= new VBox();

        Button btn1 = new Button("Click btn1");

        //functional approach
        btn1.setOnAction((ActionEvent e) -> {
            System.out.println("click on btn1");
        });

        //OOP approach:
//        1. define the class implementing interface EventHandler<ActionEvent>
//        2. implementing the "handle" method, define the actions
//        3. create an object from such class
//        4. use the object as an action


        vbox.getChildren().addAll(btn1);

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}

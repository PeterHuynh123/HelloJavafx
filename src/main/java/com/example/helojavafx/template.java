package com.example.helojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class template extends Application {

    public void start(Stage stage) throws Exception{
        HBox mainLayout = new HBox();

        Text text = new Text("hello");

        mainLayout.getChildren().addAll(text);

        Scene scene = new Scene(mainLayout, 800, 600);

        stage.setTitle("app name");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

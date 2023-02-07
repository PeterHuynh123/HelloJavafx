package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        HBox hbox = new HBox();

        final int[] counter = {1};


        Button btnMinus = new Button("-");
        Button btnAdd = new Button("+");

        Text counterTxt = new Text("   " + String.valueOf(counter[0])+ "   ");

        btnAdd.setOnAction((ActionEvent e) -> {
            counter[0]++;
            counterTxt.setText("   " + String.valueOf(counter[0])+ "   ");
        });
        btnMinus.setOnAction((ActionEvent e) -> {
            counter[0]--;
            counterTxt.setText("   " + String.valueOf(counter[0])+ "   ");
        });


        hbox.getChildren().add(btnMinus);
        hbox.getChildren().add(counterTxt);
        hbox.getChildren().add(btnAdd);

        stage.setTitle("Hello!");

        Scene scene2 = new Scene(hbox, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
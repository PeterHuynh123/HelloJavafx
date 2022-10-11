package com.example.helojavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JavaFxControls_Shapes extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox controlLayout = new VBox();

        Label labelText = new Label("This is my label");
        Text myText = new Text("This is a text control");
        ImageView iconIV = new ImageView("https://www.favicon.cc/logo3d/320000.png");
        iconIV.setPreserveRatio(true);
        iconIV.setFitHeight(50);
        Label labelIcon = new Label("Label with icon", iconIV);

        Button buttonWithIcon = new Button("Click me", new ImageView("https://www.favicon.cc/logo3d/320000.png"));
        TextField textField = new TextField("Text field with placeholder text");

        CheckBox cbox = new CheckBox("Please check me");
        cbox.setSelected(true);
        cbox.setOnAction((ActionEvent e) -> {
            System.out.println("Is my checkbox selected?: "  + cbox.isSelected());
        });

        TextArea textArea = new TextArea();
//        textArea
        textArea.setPrefRowCount(5);
        textArea.setPrefColumnCount(2);
        textArea.setWrapText(true); // break to new line automatically when reaching the end

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Top", "Jungle", "Mid", "ADC", "Support");

        ArrayList<String> food = new ArrayList<>();
        food.add("Hamburger");
        food.add("Sushi");
        food.add("Com tam");
        food.add("This is a very very nice dish that I don't know how to describe :/");

        comboBox.setMaxWidth(100);

        ObservableList<String> foodList = FXCollections.observableList(food);

        comboBox.setItems(foodList);
        comboBox.getSelectionModel().select(2); // set default value for combo box
        comboBox.setOnAction((ActionEvent event) -> {
            System.out.println("Current comboBox selected: " + comboBox.getSelectionModel().getSelectedItem());
        });

        Image zedImage = new Image("file:ZedSkin.jpeg"); // create an image object using "file:/relative path to the PROJECT FOLDER
        Image lbImage = new Image("file:images/lb.jpeg");

        ImageView zedIV = new ImageView(zedImage);
        zedIV.setPreserveRatio(true);
        zedIV.setFitHeight(200);
        ImageView lbIV = new ImageView(lbImage);
        lbIV.setPreserveRatio(true);
        lbIV.setFitHeight(300);

        ImageView iphone14 = new ImageView("file:images/iphone14.jpeg"); // combining 2 steps into 1

        // using file input stream with absolute path (not recommended)
//        Image ahriImage = new Image(new FileInputStream("/Users/doroke/KUMO/Documents/Teaching/Gia Bao - Programming/Java/HelloJavaFx/images/ahri.jpeg"));
        ImageView logo = new ImageView("https://statics.teams.cdn.office.net/hashedassets-launcher/v2/logo_teams.2806c5625995dc0f79c4747b5de9d43d.svg"); // absolute path
        logo.setFitHeight(300);
        logo.setPreserveRatio(true);

//        Circle circle = new Circle(150, 200, 120);

        Polyline polyline = new Polyline(
                200.0, 40.0,
                400.0, 50.0,
                300.0, 200.0,
                200.0,  40.0
        );

//        Font font1


        controlLayout.getChildren().addAll(labelText, myText, labelIcon, buttonWithIcon, textField, cbox, textArea, comboBox, zedIV, lbIV, iphone14, logo, polyline);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(controlLayout);

        Scene controlsScene = new Scene(scrollPane, 800, 800);
        stage.setScene(controlsScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
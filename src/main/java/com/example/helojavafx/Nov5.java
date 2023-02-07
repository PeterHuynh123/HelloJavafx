package com.example.helojavafx;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Nov5 extends Application {
//    public static void main(String[] args) {
//        enum Day { MON, TUE, WES, THU, SAT};
//
//        String[] Days =  {"MON", "TUE", "WEN"};
//
//        Day today = Day.SAT;
//
//        System.out.println("Today: " _+ Day.SAT);
//        System.out.println("Today: " + Days[0]);
//
//        if (today == Day.MON) {
//            System.out.println("Weekdays");
//        } else if (today.equals(Day.SAT)) {
//            System.out.println("Weekand");
//        }
//
//        switch (today {
//            case MON:
//                System.out.println("goto school");
//            case SAT:
//                System.out.println("Just sleep");
//        })
//    }
//public void start(Stage primaryStage) {
//    Pane pane = new Pane();
//    Rectangle rectangle = new Rectangle (0, 0, 25, 50);
//    rectangle.setFill(Color.ORANGE);
//    Circle circle = new Circle(125, 100, 50);
//    circle.setFill(Color.WHITE);
//    circle.setStroke(Color.BLACK);
//    pane.getChildren().add(circle);
//    pane.getChildren().add(rectangle);
//    PathTransition pt = new PathTransition(); // Create transition path
//    pt.setDuration(Duration.millis(40000));
//    pt.setPath(circle);
//    pt.setNode(rectangle);
//    pt.setOrientation(
//            PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//    FadeTransition ft = new FadeTransition();
//    ft.setDuration(Duration.millis(40000));
//    ft.setFromValue(1.0);
//    ft.setToValue(0.1);
//    ft.setCycleCount(Timeline.INDEFINITE);
//    ft.setAutoReverse(true);
//    ft.setNode(rectangle);
////Create RotateTransition
//    RotateTransition rt = new RotateTransition(Duration.millis(1000), rectangle);
//    rt.setFromAngle(0);
//    rt.setToAngle(360);
//    rt.setByAngle(10);
//    rt.setCycleCount(Timeline.INDEFINITE);
//    rt.setAutoReverse(false);
//    ft.play(); // Start animation
//    rt.play();
//    pt.setCycleCount(Timeline.INDEFINITE);
////    pt.setAutoReverse(false);
////    rectangle.setOnMouseClicked((MouseEvent e) -> {
////        pt.setAutoReverse(true);
////        pt.stop();
////        pt.play();
////        System.out.println("auto reverse is on");
////    });
//    pt.play(); // Start animation
//    circle.setOnMousePressed(e -> pt.pause());
//    circle.setOnMouseReleased(e -> pt.play());
//    Scene scene = new Scene(pane, 250, 200);
//    primaryStage.setTitle("PathTransitionDemo");
//    primaryStage.setScene(scene);
//    primaryStage.show();
//}
    public void start(Stage stage) {
        Text msg = new Text("JavaFX animation is cool!");
        msg.setTextOrigin(VPos.TOP);
        msg.setFont(Font.font(24));
        Pane pane = new Pane(msg);
        pane.setPrefSize(500, 70);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Scrolling Text");
        stage.show();
        double sceneWidth = scene.getWidth(); //
        double msgWidth = msg.getLayoutBounds().getWidth();

        KeyValue initKeyValue1 = new KeyValue(msg.translateXProperty(), sceneWidth);
        KeyValue initKeyValue2 = new KeyValue(msg.scaleXProperty(), 5.0);
        KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue1, initKeyValue2);


        KeyValue endKeyValue1 = new KeyValue(msg.translateXProperty(), 3.0 * msgWidth);
        KeyValue endKeyValue2 = new KeyValue(msg.scaleXProperty(), 0.2);
        KeyFrame endFrame = new KeyFrame(Duration.millis(15000), endKeyValue1, endKeyValue2);

        Timeline timeline = new Timeline(25 , initFrame, endFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setRate(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }
}

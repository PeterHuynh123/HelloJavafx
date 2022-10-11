package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;

public class JavaFXBlackJack extends Application {
    static ArrayList<Integer> playerCardIndex = new ArrayList<>();
    @Override
    public void start(Stage Stage) throws Exception {
        Rectangle bg = new Rectangle(1050.0, 600);
        bg.setFill(Color.web("#b3b5b3"));

        HBox mainLayout = new HBox();

        GridPane playerSideGp = new GridPane();
        GridPane houseSideGp = new GridPane();

        playerSideGp.minWidth(525.0);
        houseSideGp.minWidth(525.0);
        playerSideGp.minHeight(600.0);
        houseSideGp.minHeight(600.0);

        VBox playerSideLayout = new VBox();
        playerSideLayout.setMinWidth(525.0);
        HBox playerSideFirstCardRow = new HBox();
        HBox playerSideSecondCardRow = new HBox();
        Text playerScoreSum = new Text("Your score: ");
        HBox playerButtonLayout = new HBox();




        VBox houseSideLayout = new VBox();
        HBox houseSideFirstCardRow = new HBox();
        HBox houseSideSecondCardRow = new HBox();
        Text houseScoreSum = new Text("Computer score: ");

        Button btnGetCard = new Button("Get card");
        Button btnBet = new Button("Bet");
        Button btnForfeit = new Button("Forfeit");

        playerScoreSum.setText("Your score: 0");
//        System.out.println(playerCardIndex.toString());
        playerSideSecondCardRow.setMinHeight(254.1);
//        ArrayList<Integer> houseFirst2CardIndex  = getFirst2CardIndex();
//        houseScoreSum.setText("Computer score: " + getTotalCardValue(houseFirst2CardIndex));
////        System.out.println(playerCardIndex.toString());
//
//        cardUrl = String.format("file:cards/%d.png", houseFirst2CardIndex.get(0));
//
//        tempCardHolder = new Image(cardUrl);
//        ImageView houseFirstCardImgV = new ImageView(tempCardHolder);
//        cardUrl = String.format("file:cards/%d.png", houseFirst2CardIndex.get(1));
//        tempCardHolder = new Image(cardUrl);
//        ImageView houseSecondCardImgV = new ImageView(tempCardHolder);
//
//        houseFirstCardImgV.setPreserveRatio(true);
//        houseSecondCardImgV.setPreserveRatio(true);
//
//        houseFirstCardImgV.setFitWidth(175.0);
//        houseSecondCardImgV.setFitWidth(175.0);
//
//        houseSideFirstCardRow.getChildren().addAll(houseFirstCardImgV, houseSecondCardImgV);




        playerButtonLayout.getChildren().addAll(btnGetCard, btnBet, btnForfeit);


        playerSideLayout.getChildren().addAll(playerSideFirstCardRow, playerSideSecondCardRow, playerScoreSum, playerButtonLayout);
        houseSideLayout.getChildren().addAll(houseSideFirstCardRow, houseSideSecondCardRow, houseScoreSum);

        playerSideGp.getChildren().addAll(playerSideLayout);
        houseSideGp.getChildren().addAll(houseSideLayout);




        mainLayout.getChildren().addAll(playerSideGp, houseSideGp);

        btnGetCard.setOnAction((ActionEvent handler) -> {
            if (playerCardIndex.size() == 0) {
                getFirst2CardIndex(playerSideFirstCardRow);
                playerScoreSum.setText("Your score: " + getTotalCardValue());
            } else {
                playerCardIndex.add(getAnotherCardIndex(playerCardIndex, playerSideFirstCardRow, playerSideSecondCardRow));
                playerScoreSum.setText("Your score: " + getTotalCardValue());
            }
            getTotalCardValue();
            });


        
        btnForfeit.setOnAction((ActionEvent e) -> {
            playerSideFirstCardRow.getChildren().clear();
            playerSideSecondCardRow.getChildren().clear();
            playerCardIndex.clear();
            getTotalCardValue();
            getFirst2CardIndex(playerSideFirstCardRow);
            playerScoreSum.setText("Your score: " + getTotalCardValue());
        });


        Scene scene = new Scene(mainLayout, 1050, 600);

        Stage.setTitle("BlackJack");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void getFirst2CardIndex(HBox playerSideFirstCardRow) {
        int firstCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
        int secondCardIndex = firstCardIndex;
        while (secondCardIndex == firstCardIndex) {
            secondCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
        }

        playerCardIndex.add(firstCardIndex);
        playerCardIndex.add(secondCardIndex);

        String cardUrl = String.format("file:cards/%d.png", playerCardIndex.get(0));

        Image tempCardHolder = new Image(cardUrl);
        ImageView playerFirstCardImgV = new ImageView(tempCardHolder);

        cardUrl = String.format("file:cards/%d.png", playerCardIndex.get(1));

        tempCardHolder = new Image(cardUrl);
        ImageView playerSecondCardImgV = new ImageView(tempCardHolder);

        playerFirstCardImgV.setPreserveRatio(true);
        playerSecondCardImgV.setPreserveRatio(true);

        playerFirstCardImgV.setFitWidth(175.0);
        playerSecondCardImgV.setFitWidth(175.0);


        playerSideFirstCardRow.getChildren().addAll(playerFirstCardImgV, playerSecondCardImgV);
        getTotalCardValue();
    };

    public static int getTotalCardValue() {
        int totalCardVal = 0;
        for (int card:playerCardIndex) {
            int cardValue = card%13;
            if (cardValue>10 || cardValue == 0) {
                cardValue = 10;
            }
            if (card == 100) {
                cardValue = 0;
                return totalCardVal;
            }
            System.out.println(cardValue + " " +card);
            totalCardVal += cardValue;
        }
        return totalCardVal;
    };

        public static Integer getAnotherCardIndex(ArrayList<Integer> cardIndexList, HBox firstCardRow, HBox secondCardRow){
            int newCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
            for (int cardIndex:cardIndexList) {
                if (newCardIndex == cardIndex) {
                    newCardIndex += 1;
                }
            }
            String cardUrl = String.format("file:cards/%d.png", newCardIndex);
            Image tempCardHolder = new Image(cardUrl);
            ImageView playerTempCardImgV = new ImageView(tempCardHolder);

            playerTempCardImgV.setPreserveRatio(true);

            playerTempCardImgV.setFitWidth(175.0);

            if (firstCardRow.getChildren().size() < 3) {
                firstCardRow.getChildren().addAll(playerTempCardImgV);
            } else if (secondCardRow.getChildren().size() < 2){
                secondCardRow.getChildren().addAll(playerTempCardImgV);
            } else {
                System.out.println("Maxed cards pulled");
                newCardIndex = 100;
            }
            getTotalCardValue();
            return newCardIndex;
        };

    public static void main(String[] args) {
        launch(args);
    }
}

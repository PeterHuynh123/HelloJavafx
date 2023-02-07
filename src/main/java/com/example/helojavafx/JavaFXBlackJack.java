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
        HBox playerButtonLayout = new HBox();
        Text playerScoretxt = new Text("Your score: ");




        VBox houseSideLayout = new VBox();
        HBox houseSideFirstCardRow = new HBox();
        HBox houseSideSecondCardRow = new HBox();
        Text txtHouseResult = new Text("Computer score: ?");

        Button btnGetCard = new Button("Get card");
        Button btnBet = new Button("Bet");
        Button btnForfeit = new Button("Forfeit");

        boolean bet = false;

        playerScoretxt.setText("Your score: 0");
//        System.out.println(playerCardIndex.toString());
        playerSideFirstCardRow.setMinHeight(254.1);
        playerSideSecondCardRow.setMinHeight(254.1);



        houseSideFirstCardRow.setMinHeight(254.1);
        houseSideSecondCardRow.setMinHeight(254.1);

        ArrayList<Integer> playerCardIndex = new ArrayList<>();
        ArrayList<Integer> houseCardIndex  = new ArrayList<>();

        makeFirst2CardIndex(houseSideFirstCardRow, houseCardIndex, false);
        while (getTotalCardValue(houseCardIndex) <= 17 && houseSideSecondCardRow.getChildren().size() != 5) {
            System.out.println(getTotalCardValue(houseCardIndex));
            System.out.println("hello");
            houseCardIndex.add(getAnotherCardIndex(houseCardIndex, houseSideFirstCardRow, houseSideSecondCardRow, false));
        }
//        txtHouseResult.setText("Computer score: " + getTotalCardValue(houseFirst2CardIndex));
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


        playerSideLayout.getChildren().addAll(playerSideFirstCardRow, playerSideSecondCardRow, playerScoretxt, playerButtonLayout);
        houseSideLayout.getChildren().addAll(houseSideFirstCardRow, houseSideSecondCardRow, txtHouseResult);

        playerSideGp.getChildren().addAll(playerSideLayout);
        houseSideGp.getChildren().addAll(houseSideLayout);




        mainLayout.getChildren().addAll(playerSideGp, houseSideGp);



        btnGetCard.setOnAction((ActionEvent handler) -> {
            if (playerCardIndex.size() == 0) {
                makeFirst2CardIndex(playerSideFirstCardRow, playerCardIndex, true);
                playerScoretxt.setText("Your score: " + getTotalCardValue(playerCardIndex));
            } else {
                playerCardIndex.add(getAnotherCardIndex(playerCardIndex, playerSideFirstCardRow, playerSideSecondCardRow, true));
                playerScoretxt.setText("Your score: " + getTotalCardValue(playerCardIndex));
            }
            getTotalCardValue(playerCardIndex);
        });

        btnBet.setOnAction((ActionEvent e) -> {
            if (!bet) {
                displayHouse(houseSideFirstCardRow, houseSideSecondCardRow, houseCardIndex, txtHouseResult);
                getBetResult(playerCardIndex, houseCardIndex, getTotalCardValue(playerCardIndex), getTotalCardValue(playerCardIndex), boolean bet);
            }

        });
        
        btnForfeit.setOnAction((ActionEvent e) -> {
            playerSideFirstCardRow.getChildren().clear();
            playerSideSecondCardRow.getChildren().clear();
            playerCardIndex.clear();
            getTotalCardValue(playerCardIndex);
            makeFirst2CardIndex(playerSideFirstCardRow, playerCardIndex, true);
            playerScoretxt.setText("Your score: " + getTotalCardValue(playerCardIndex));
        });


        Scene scene = new Scene(mainLayout, 1050, 600);

        Stage.setTitle("BlackJack");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void makeFirst2CardIndex(HBox firstCardRow, ArrayList<Integer> cardIndex, boolean isPlayer) {
        int firstCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
        int secondCardIndex = firstCardIndex;
        while (secondCardIndex == firstCardIndex) {
            secondCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
        }

        cardIndex.add(firstCardIndex);
        cardIndex.add(secondCardIndex);

        ImageView firstCardImgV;
        ImageView secondCardImgV;

        if (isPlayer) {
            String cardUrl = String.format("file:cards/%d.png", cardIndex.get(0));

            Image tempCardHolder = new Image(cardUrl);
            firstCardImgV = new ImageView(tempCardHolder);

            cardUrl = String.format("file:cards/%d.png", cardIndex.get(1));

            tempCardHolder = new Image(cardUrl);
            secondCardImgV = new ImageView(tempCardHolder);
        } else {
            String cardUrl = "file:cards/mysteriouscard.png";
            Image tempCardHolder = new Image(cardUrl);
            firstCardImgV = new ImageView(tempCardHolder);
            secondCardImgV = new ImageView(tempCardHolder);
        }

        firstCardImgV.setPreserveRatio(true);
        secondCardImgV.setPreserveRatio(true);

        firstCardImgV.setFitWidth(175.0);
        secondCardImgV.setFitWidth(175.0);


        firstCardRow.getChildren().addAll(firstCardImgV, secondCardImgV);
    };

    public static int getTotalCardValue(ArrayList<Integer> cardIndex) {
        int totalCardVal = 0;
        for (int card:cardIndex) {
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

        public static Integer getAnotherCardIndex(ArrayList<Integer> cardIndexList, HBox firstCardRow, HBox secondCardRow, boolean isPlayer){
            int newCardIndex = (int) ((Math.random() * (52 -  1)) + 1);
            for (int cardIndex:cardIndexList) {
                if (newCardIndex == cardIndex) {
                    newCardIndex += 1;
                }
            }

            String cardUrl = String.format("file:cards/%d.png", newCardIndex);

            if (!isPlayer) {
                cardUrl = "file:cards/mysteriouscard.png";
            }

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
            getTotalCardValue(cardIndexList);
            return newCardIndex;
        };

        public void displayHouse(HBox firstCardRow, HBox secondCardRow, ArrayList<Integer> cardIndexList, Text txtHouseResult) {
            txtHouseResult.setText("Computer score: " + getTotalCardValue(cardIndexList));

            firstCardRow.getChildren().clear();
            secondCardRow.getChildren().clear();
            for (int cardIndex:cardIndexList) {
                Image tempCardHolder = new Image(String.format("file:cards/%d.png", cardIndex));
                ImageView TempCardImgV = new ImageView(tempCardHolder);
                TempCardImgV.setPreserveRatio(true);
                TempCardImgV.setFitWidth(175.0);
                if (firstCardRow.getChildren().size() == 3) {
                    System.out.println("lol");
                    secondCardRow.getChildren().add(TempCardImgV);
                }
                else {
                    firstCardRow.getChildren().add(TempCardImgV);
                }
            }
        }

        public void getBetResult(ArrayList<Integer> playerCardIndex, ArrayList<Integer> houseCardIndex, int playerScore, int houseScore) {
            System.out.println("haha");
            bet = true;
        }

    public static void main(String[] args) {
        launch(args);
    }
}

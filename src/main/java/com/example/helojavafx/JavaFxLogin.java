package com.example.helojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.security.Key;

public class JavaFxLogin extends Application {
    final static String username = "Peter123";
    final static String password = "123456789";
    static int allowedLoginAttempts = 5;
    boolean isEligibleAccount = true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainLayout = new VBox();


        HBox usernameInputLayout = new HBox();
        Label usernameLabel = new Label("Username: ");
        TextField usernameInput = new TextField();
        usernameInputLayout.getChildren().addAll(usernameLabel, usernameInput);


        HBox passwordInputLayout = new HBox();
        Label passwordLabel = new Label("Password: ");
        PasswordField passwordInput = new PasswordField();
        passwordInputLayout.getChildren().addAll(passwordLabel, passwordInput);

        Button btnLogin = new Button("Login");
        Label loginStatus = new Label(" ");

        EventHandler<KeyEvent> onLoginSubmitted = new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event){
                if (event.getCode().equals(KeyCode.ENTER)){
                    loginHandler(isEligibleAccount, usernameInput, passwordInput, loginStatus);
                }
            }
        };

        passwordInput.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                loginHandler(isEligibleAccount, usernameInput, passwordInput, loginStatus);
            }
        });
        usernameInput.addEventFilter(KeyEvent.KEY_PRESSED, onLoginSubmitted);

        btnLogin.setOnAction((ActionEvent userInfoCheck) -> {
            loginHandler(isEligibleAccount, usernameInput, passwordInput, loginStatus);
        });

        mainLayout.getChildren().addAll(
                usernameInputLayout,
                passwordInputLayout,
                btnLogin,
                loginStatus);

        Scene scene = new Scene(mainLayout, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void loginHandler(boolean isEligibleAccount,
                                    TextField usernameInput,
                                    PasswordField passwordInput,
                                    Label loginStatus) {
        if (allowedLoginAttempts > 0 && isEligibleAccount) {
            if (usernameInput.getText().equals(username)) {
                if (passwordInput.getText().equals(password)) {
                    loginStatus.setText("Login Successfully");
                    loginStatus.setTextFill(Color.web("#00ff44"));
                }else {
                    loginStatus.setText("Password or Username does not matched ("+ (allowedLoginAttempts)+" tries left)");
                    loginStatus.setTextFill(Color.web("#ff0000"));
                    --allowedLoginAttempts;
                }
            }else if (allowedLoginAttempts == 1) {
                loginStatus.setText("!!!YOU ONLY HAVE 1 TRY LEFT, IF YOU FAILED TO LOGIN, THIS ACCOUNT WILL BE LOCKED!!!");
                loginStatus.setTextFill(Color.web("#ff0000"));
                --allowedLoginAttempts;
            } else {
                loginStatus.setText("Password or Username does not matched ("+ (allowedLoginAttempts)+" tries left)");
                loginStatus.setTextFill(Color.web("#ff0000"));
                --allowedLoginAttempts;
            }
        } else {
            loginStatus.setText("This account is locked");
            loginStatus.setTextFill(Color.web("#ff0000"));
            usernameInput.setDisable(true);
            passwordInput.setDisable(true);
        }
        usernameInput.setText("");
        passwordInput.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package gui.controllers;

import gui.screens.ScreenManger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *  Created by nima on 5/15/16.
 */
public class LogInController {

    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    ScreenManger screenManager;


    public void init(ScreenManger screenManger) {
        this.screenManager = screenManger;
    }


    public void logInButtonClick(ActionEvent actionEvent) {
        //TODO
        print("LogInButton function not defined");
    }

    public void exitButtonClick(ActionEvent actionEvent){
        Platform.exit();
    }

    public void signUpButtonClick(ActionEvent actionEvent) {
        screenManager.showSignUpScene();
    }


    public void print(String s){
        System.out.println(s);
    }
}

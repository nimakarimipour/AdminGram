package gui.controllers;

import gui.screens.ScreenManger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *  Created by nima on 5/15/16.
 */
public class SignUpController {

    @FXML
    TextField username;
    @FXML
    TextField mail;
    @FXML
    TextField phoneNumber;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirmPassword;

    ScreenManger screenManager;


    public void init(ScreenManger screenManger) {
        this.screenManager = screenManger;
    }


    public void exitButtonClick(ActionEvent actionEvent){
        Platform.exit();
    }

    public void backButtonClick(ActionEvent actionEvent) {
        screenManager.showLogInScene();
    }

    public void signUpButtonClick(ActionEvent actionEvent){
        //TODO Not Done.
        print("Not Defined singUpButtonClick function");

    }



    public void print(String s){
        System.out.println(s);
    }
}

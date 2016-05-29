package gui.screens;

import gui.widgets.button.HoverButton;
import gui.widgets.inputs.ColoredTextField;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *  Created by nima on 5/15/16.
 */

public class LogInScene extends TappedScene {

    private TextField username;
    private TextField password;
    private VBox box;


    public LogInScene(Parent root, double width, double height, ScreenManger screenManger) {
        super(root, width, height, screenManger);
    }


    @Override
    protected void setStyle(){
        super.setStyle();
        this.setFill(Color.TRANSPARENT);
        this.getStylesheets().add(String.valueOf(getClass().getResource("../styleSheets/log-in.css")));
    }

    @Override
    protected void initThemePositionAndSize(BorderPane main, StackPane tape) {
        tape.setMinHeight(150);
        main.setTop(tape);
    }

    @Override
    protected void setUpChildren() {
        super.requestLogo();
        setUpInputFields();
        setUpTexts();
        setUpButtons();
    }


    private void setUpButtons() {
        HoverButton logInButton = new HoverButton("Log In", 200, 40, Color.rgb(23, 190, 30));
        logInButton.setOnAction(event -> screenManger.showMainScene());
        box.getChildren().add(logInButton);
    }

    private void setUpTexts() {
        Hyperlink link = new Hyperlink("Create a Account");
        link.setOnAction(event -> screenManger.showSignUpScene());
        box.getChildren().add(link);
    }

    private void setUpInputFields() {
        username = new ColoredTextField(Color.rgb(30, 0, 53, 0.7));
        password = new ColoredTextField(Color.rgb(30, 0, 53, 0.7));
        username.setPromptText("Username");
        password.setPromptText("Password");
        username.setMaxWidth(length);
        username.setMinWidth(length);
        password.setMaxWidth(length);
        password.setMinWidth(length);
        box = new VBox(username, password);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        root.setCenter(box);
    }
}


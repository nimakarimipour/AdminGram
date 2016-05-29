package gui.screens;

import gui.widgets.inputs.ColoredTextField;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


/**
 *  Created by nima on 5/15/16.
 */
public class SignUpScene extends TappedScene {

    private ColoredTextField username, password, email, confirmPassword, phoneNumber;
    private VBox box;
    private ArrayList<ColoredTextField> inputs;
    private static String[] inputNames = {"Username", "E-Mail", "Phone Number (Optional)", "Password", "Conform Password"};
    private static Color color = Color.rgb(52, 205, 110);


    public SignUpScene(Parent root, double width, double height, ScreenManger s) {
        super(root, width, height, s);
    }


    @Override
    protected void setStyle() {
        super.setStyle();
        this.getStylesheets().add(String.valueOf(getClass().getResource("../styleSheets/sign-up.css")));
    }

    @Override
    protected void initThemePositionAndSize(BorderPane main, StackPane tape) {
        tape.setMinHeight(150);
        main.setTop(tape);
    }

    @Override
    protected void setUpChildren() {
        super.requestLogo();
        inputs = new ArrayList<>();
        setUpInputs();
        setUpLayouts();

    }


    private void setUpLayouts() {
        box = new VBox();
        box.getChildren().addAll(username, email, password, confirmPassword, phoneNumber);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(15);
        root.setCenter(box);
    }

    private void setUpInputs() {
        username = new ColoredTextField(color);
        inputs.add(username);
        email = new ColoredTextField(color);
        inputs.add(email);
        phoneNumber = new ColoredTextField(color);
        inputs.add(phoneNumber);
        password = new ColoredTextField(color);
        inputs.add(password);
        confirmPassword = new ColoredTextField(color);
        inputs.add(confirmPassword);
        setProperties();
    }

    private void setProperties() {
        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).setPromptText(inputNames[i]);
            inputs.get(i).getStyleClass().add("input");
            inputs.get(i).setMinWidth(300);
            inputs.get(i).setMaxWidth(300);
        }
    }
}

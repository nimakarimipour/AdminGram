package gui.screens;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *  Created by nima on 5/17/16.
 */

public abstract class TappedScene extends Scene {

    private BorderPane main;

    protected StackPane tape;
    protected BorderPane root;
    protected Rectangle theme;
    protected int length = 300;
    protected double width, height;

    protected ScreenManger screenManger;


    public TappedScene(Parent root, double width, double height, ScreenManger screenManger) {
        super(root, width, height);
        if(!root.getClass().equals(BorderPane.class)) throw new RuntimeException("The Root Must be BorderPane");
        main = (BorderPane) root;
        this.screenManger = screenManger;
        setUp(width, height);
        setStyle();
        setUpChildren();
    }


    private void setUp(double width, double height) {
        this.width = width;
        this.height = height;
        setUpLayout();
        setUpTheme();
    }

    private void setUpLayout() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: rgb(255, 255, 255);");
        main.setCenter(root);
    }

    private void setUpTheme() {
        tape = new StackPane();
        tape.setAlignment(Pos.CENTER);
        initThemePositionAndSize(main, tape);
        tape.getStyleClass().add("theme");
    }

    private void setLogo(StackPane tape) {
        ImageView logo = new ImageView(String.valueOf(getClass().getResource("../pictures/Telegram-Logo.png")));
        tape.getChildren().addAll(logo);
    }


    protected void setStyle() {
        this.setFill(Color.TRANSPARENT);
    }

    protected void requestLogo(){
        setLogo(tape);
    }


    protected abstract void setUpChildren();

    protected abstract void initThemePositionAndSize(BorderPane main, StackPane tape);
}

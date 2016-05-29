package gui.screens;

import engine.Engine;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;


/**
 *  Created by nima on 5/15/16.
 */

public class ScreenManger {

    private Stage stage;
    private Engine engine;
    private double xOffset, yOffset;
    private Dimension dimension;
    Scene logInScene, signUpScene, mainScene;
    FadeTransition fadeOut, fadeIn;


    public ScreenManger(Stage stage, Engine engine) {
        this.stage = stage;
        this.engine = engine;
        getScreenSize();
        initScenes();
        initTransitions();
    }


    private void initTransitions() {
        fadeIn = new FadeTransition(Duration.millis(200));
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeOut = new FadeTransition(Duration.millis(200));
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
    }

    private void getScreenSize() {
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private void initScenes() {
        initStartScene();
        initSignUpScene();
        initMainScene();
    }

    private void initMainScene() {
        mainScene = new MainScene(new BorderPane(), 1000, 650, this);
    }

    private void initSignUpScene() {
        signUpScene = new SignUpScene(new BorderPane(), 750, 500, this);
    }

    private void initStartScene() {
        logInScene = new LogInScene(new BorderPane(), 500, 400, this);
    }

    private void makeMovableScene(Scene scene) {
        scene.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    private void changeSceneWithFadeTransition(Scene from, Scene to) {
        fadeOut.stop();
        fadeIn.stop();
        fadeOut.setNode(from.getRoot());
        fadeIn.setNode(to.getRoot());
        fadeOut.setOnFinished(event -> {
            fadeIn.play();
            stage.setScene(to);
            makeMovableScene(to);
        });
        fadeOut.play();
    }


    public void showLogInScene() {
        changeSceneWithFadeTransition(signUpScene, logInScene);
        if (!stage.getStyle().equals(StageStyle.TRANSPARENT)) stage.initStyle(StageStyle.TRANSPARENT);
    }

    public void showSignUpScene() {
        changeSceneWithFadeTransition(logInScene, signUpScene);
        if (!stage.getStyle().equals(StageStyle.TRANSPARENT)) stage.initStyle(StageStyle.TRANSPARENT);
    }

    public void showMainScene(){
        changeSceneWithFadeTransition(logInScene, mainScene);
        if (!stage.getStyle().equals(StageStyle.TRANSPARENT)) stage.initStyle(StageStyle.TRANSPARENT);
    }
}
package gui.widgets.inputs;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;


/**
 *  Created by nima on 5/16/16.
 */
public class ColoredTextField extends TextField {

    private Line base, focusLine;
    private Group g;
    private Timeline focusAnimation;
    private int padding = 0;
    private boolean animIsGoing;
    private Color color;
    private int animTimeMillis = 250;



    public ColoredTextField(Color color){
        super();
        this.color = color;
        setStyle("-fx-background-color: transparent;\n" +
                "-fx-border-color: transparent;\n"+
                "-fx-prompt-text-fill: rgb(255, 255, 255) ;");
        g = new Group();
        setLines();
    }


    private void setUpAnimations() {
        focusAnimation = new Timeline(new KeyFrame(Duration.millis(animTimeMillis),
                                      new KeyValue(focusLine.endXProperty(), getWidth() - padding),
                                      new KeyValue(focusLine.startXProperty(), padding)));
        focusAnimation.setOnFinished(event -> animIsGoing = true);
        focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                focusAnimation.play();
                animIsGoing = true;
                focusLine.setVisible(true);
            }
            if(oldValue) {
                focusAnimation.stop();
                focusLine.setVisible(false);
                focusLine.setEndX(getWidth() / 2);
                focusLine.setStartX(getWidth() / 2);
                animIsGoing = false;
            }
        });

    }

    private void setLines() {
        base = new Line(0, 0, 0, 0);
        focusLine = new Line(0, 0, 0, 0);
        focusLine.setVisible(false);
        g.getChildren().addAll(base, focusLine);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        Skin<?> defaultSkin = super.createDefaultSkin();
        getChildren().add(0, g);
        widthProperty().addListener(e -> {
            base.setStartX(padding);
            base.setEndX(getWidth() - padding);
            if(!animIsGoing) {
                focusLine.setStartX(getWidth() / 2);
                focusLine.setEndX(getWidth() / 2);
            }
            setUpAnimations();
        });
        focusLine.setStroke(color);
        focusLine.setStrokeWidth(3f);
        return defaultSkin;
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        getChildren().get(0).setTranslateY(getHeight() / 2);
    }
}

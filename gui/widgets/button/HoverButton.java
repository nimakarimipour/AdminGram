package gui.widgets.button;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *  Created by nima on 5/17/16.
 */



public class HoverButton extends BorderPane {

    private StackPane root;
    private Rectangle back, front;
    private FadeTransition fadeIn, fadeOut;
    private String text;
    private Text label;
    private Color color;

    int height, width;


    public HoverButton(String text, int width, int height, Color color){
        this.text = text;
        this.width = width;
        this.height = height;
        this.color = color;
        setUpChildren();
        setUpBounds();
    }


    private void setUpBounds() {
        this.setMinWidth(width);
        this.setMaxWidth(width);
        this.setMaxHeight(height);
        this.setMinHeight(height);
    }

    private void setUpChildren() {
        label = new Text(this.getText());
        label.setFont(new Font(15));
        setUpRectangles();
        setUpAnimation();
        addEventHandlers();
        root = new StackPane(back, front, label);
        this.setCenter(root);
    }

    private void setUpRectangles() {
        back = new Rectangle(width, height, Color.rgb(255, 255, 255, 0));
        front = new Rectangle(width, height, color);
        front.setArcHeight(10);
        front.setArcWidth(10);
        back.setArcHeight(10);
        back.setArcWidth(10);
        back.setStrokeWidth(2f);
        back.setStroke(color);
    }

    private void addEventHandlers() {
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            label.setStyle("-fx-fill: rgb(255, 255, 255)");
            front.setVisible(true);
            fadeOut.stop();
            fadeIn.play();
        });
        this.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            label.setStyle("-fx-fill: rgb(0, 0, 0)");
            fadeIn.stop();
            fadeOut.play();
        });

    }

    private void setUpAnimation() {
        front.setVisible(false);
        fadeIn = new FadeTransition(Duration.millis(300), front);
        fadeIn.setToValue(1);
        fadeIn.setFromValue(0);
        fadeOut = new FadeTransition(Duration.millis(300), front);
        fadeOut.setToValue(0);
        fadeOut.setFromValue(1);
        fadeOut.setOnFinished(e -> front.setVisible(false));
    }


    public String getText(){
        return text;
    }

    public void setOnAction(EventHandler<MouseEvent> e){
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, e);
    }
}

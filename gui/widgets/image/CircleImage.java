package gui.widgets.image;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *  Created by nima on 5/23/16.
 */
public class CircleImage extends StackPane {

    Image image;
    Circle circle;


    public CircleImage(String src){
        image = new Image(String.valueOf(getClass().getResource("../../../" + src)));
        circle = new Circle(Math.min(image.getWidth(), image.getHeight()));
        ImagePattern pattern = new ImagePattern(image);
        circle.setFill(pattern);
        this.getChildren().add(circle);
    }
}

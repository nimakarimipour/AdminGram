import gui.widgets.image.CircleImage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 *  Created by nima on 5/16/16.
 */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();

        pane.setCenter(new CircleImage("gui/pictures/Bird.jpg"));

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
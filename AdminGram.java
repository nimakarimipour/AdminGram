import engine.Engine;
import gui.screens.ScreenManger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *  Created by nima on 5/15/16.
 */

public class AdminGram extends Application{

    ScreenManger screenManger;
    Engine engine;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();
        //TODO set up connection
    }


    public void start(Stage stage) throws Exception {
        setUp(stage);
        screenManger.showMainScene();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    private void setUp(Stage stage) {
        screenManger = new ScreenManger(stage, engine);
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        //TODO close connection & save
    }
}
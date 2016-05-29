import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *  Created by nima on 5/19/16.
 */

public class Saver{

    public static void main(String[] args) {
        try {
            String s = "M2.379,14.729 5.208,11.899 12.958,19.648 25.877,6.733" +
                    " 28.707,9.561 12.958,25.308z";

            FileOutputStream f = new FileOutputStream("src/gui/widgets/logo/Done.Logo");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(s);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {

            VBox pane = new VBox(new Logo(Logo.Type.PREVIOUS), new Logo(Logo.Type.REMOVE),
                                new Logo(Logo.Type.DONE), new Logo(Logo.Type.HELP));
            pane.setSpacing(20);
            pane.setAlignment(Pos.CENTER);
            Scene scene = new Scene(pane, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

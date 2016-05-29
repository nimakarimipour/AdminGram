package gui.widgets.logo;

import javafx.scene.shape.SVGPath;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *  Created by nima on 5/19/16.
 */
public class Logo extends SVGPath implements Serializable {




    public enum Type {
        USER("User"),
        ABOUT_US("AboutUs"),
        ADD("Add"),
        CANCEL("Cancel"),
        CLOSE("Close"),
        DELETE_ALL("DeleteAll"),
        DONE("Done"),
        HELP("Help"),
        NEXT("Next"),
        PREVIOUS("Previous"),
        REMOVE("Remove");

        String name;

        Type(String name) {
            this.name = name;
        }
    }


    public Logo(Type type){
        super();
        //type.setContent(this);
        setUp(type);
    }

    private void setUp(Type type) {
        try {
            FileInputStream f = new FileInputStream("src/gui/widgets/logo/" + type.name + ".Logo");
            ObjectInputStream o = new ObjectInputStream(f);
            this.setContent((String) o.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
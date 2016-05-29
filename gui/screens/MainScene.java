package gui.screens;

import gui.widgets.sidebar.MenuSideBar;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.HashMap;


/**
 *  Created by nima on 5/21/16.
 */

public class MainScene extends TappedScene {

    HashMap<String, Pane> panes;
    MenuSideBar menuSideBar;
    StackPane root;
    static String[] tabsName = {"Cancel", "Add", "Done", "About Us", "User", "Close", "Delete All", "Help", "Next", "Previous", "Remove"};

    public MainScene(Parent root, double width, double height, ScreenManger screenManger) {
        super(root, width, height, screenManger);
    }


    @Override
    protected void setStyle() {
        super.setStyle();
        this.getStylesheets().add(String.valueOf(getClass().getResource("../styleSheets/main.css")));
    }

    @Override
    protected void initThemePositionAndSize(BorderPane main, StackPane tape) {
        tape.setMinWidth(250);
        main.setLeft(tape);
    }

    @Override
    public void setUpChildren() {
        root = new StackPane();
        super.root.setCenter(this.root);
        panes = new HashMap<>();
        setUpPanes();
        super.tape.getChildren().add(menuSideBar);
    }

    private void setUpPanes() {
        for (String s : tabsName){
            BorderPane p = new BorderPane(new Button(s));
            p.setVisible(false);
            root.getChildren().add(p);
            panes.put(s, p);
        }
        menuSideBar = new MenuSideBar(panes);
    }
}

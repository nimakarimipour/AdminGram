package gui.widgets.sidebar;

import gui.widgets.logo.Logo;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *  Created by nima on 5/16/16.
 */

public class SideBarItem extends BorderPane {

    private StackPane root;
    private HBox selectionPanel;
    private GridPane infoPanel;
    private Label label;
    private Logo icon;
    private FadeTransition fadeOut, fadeIn;
    private Rectangle dark, green;
    private Pane pane;
    private boolean isSelected;


    public SideBarItem(String name, Logo logo, Pane pane) {
        this.icon = logo;
        this.pane = pane;
        setUpLayout(name);
        setUpChildren(logo);
        setUpAnimation();
        setFills();
    }


    private void setFills() {
        icon.setFill(Color.rgb(199, 193, 190));
        label.setTextFill(Color.rgb(240, 240, 240));
    }

    private void setUpAnimation() {
        fadeIn = new FadeTransition(Duration.millis(250), dark);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeOut = new FadeTransition(Duration.millis(500), dark);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(event -> dark.setVisible(false));
        setEventHandlers();
    }

    private void setEventHandlers() {
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            dark.setVisible(true);
            if(!isSelected) {
                fadeOut.stop();
                fadeIn.play();
            }
        });
        this.addEventHandler(MouseEvent.MOUSE_EXITED ,event -> {
            if(!isSelected) {
                fadeIn.stop();
                fadeOut.play();
            }
        });
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            MenuSideBar.current.deActive();
            if(!isSelected){
                green.setVisible(true);
                pane.setVisible(true);
            }
            isSelected = (!isSelected);
            MenuSideBar.current = this;
        });
    }

    private void setUpLayout(String name) {
        root = new StackPane();
        root.setAlignment(Pos.CENTER);
        selectionPanel = new HBox();
        selectionPanel.setAlignment(Pos.CENTER);
        label = new Label(name);
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER_RIGHT);
        infoPanel = new GridPane();
        this.setCenter(root);
    }

    private void setUpChildren(Logo icon) {
        green = new Rectangle(8, 30, Color.rgb(3, 195, 15, 0.7));
        dark = new Rectangle(242, 30, Color.rgb(31, 31, 31));
        dark.setVisible(false);
        green.setVisible(false);
        selectionPanel.getChildren().addAll(green, dark);
        selectionPanel.setVisible(true);
        setUpInfoPanel(icon);
        root.getChildren().addAll(selectionPanel, infoPanel);
    }

    private void setUpInfoPanel(Logo icon) {
        StackPane iconPane = new StackPane(icon);
        StackPane labelPane = new StackPane(label);
        iconPane.setPadding(new Insets(0, 0, 0, 20));
        labelPane.setPadding(new Insets(0, 20, 0, 0));
        iconPane.setAlignment(Pos.CENTER_LEFT);
        labelPane.setAlignment(Pos.CENTER_RIGHT);
        infoPanel.add(iconPane, 0, 0);
        infoPanel.add(labelPane, 1, 0);
        infoPanel.getColumnConstraints().add(new ColumnConstraints(100));
    }


    public void deActive(){
        fadeIn.stop();
        fadeOut.play();
        isSelected = false;
        green.setVisible(false);
        pane.setVisible(false);
    }

    public void hidePane(){
        pane.setVisible(false);
    }

    public Pane getPane(){
        return pane;
    }
}
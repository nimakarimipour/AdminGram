package gui.widgets.sidebar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *  Created by nima on 5/21/16.
 */
public class GroupSideBarItem extends VBox{


    Text text;

    public GroupSideBarItem(String label){
        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        setUpText(label);
    }

    private void setUpText(String label) {
        text = new Text(label);
        text.setFill(Color.GRAY);
        StackPane textPane = new StackPane(text);
        textPane.setAlignment(Pos.CENTER);
        textPane.setPadding(new Insets(0, 0, 0, 0));
        this.getChildren().add(textPane);
    }

    public void addItems(SideBarItem... items) {
        this.getChildren().addAll(items);
    }
}

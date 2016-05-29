package gui.widgets.sidebar;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *  Created by nima on 5/22/16.
 */
public class SideBarInfo extends StackPane {

    Text text;


    public SideBarInfo() {
        setUpLayout();
        setUpChildren();
    }


    private void setUpChildren() {
        text = new Text("Info Panel");
        text.setFill(Color.WHITE);
        text.setFont(new Font(20));
        this.getChildren().add(text);
    }

    private void setUpLayout() {
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: rgb(250, 60, 17, 0.9);");
        this.setTranslateY(-20);
        this.setMinHeight(70);
    }


    public void setText(String s){
        text.setText(s);
    }

    public String getText(){
        return text.getText();
    }
}
package gui.widgets.sidebar;

import gui.widgets.logo.Logo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import java.util.HashMap;

/**
 *  Created by nima on 5/22/16.
 */
public class MenuSideBar extends VBox {

    static SideBarItem current;
    GroupSideBarItem channels, users, payment, notifications;
    SideBarInfo sideBarInfo;
    HashMap<String, Pane> tabs;


    public MenuSideBar(HashMap<String, Pane> tabs){
        this.setPadding(new Insets(30, 0, 0, 0));
        this.setSpacing(20);
        this.setAlignment(Pos.TOP_CENTER);
        this.tabs = tabs;
        setUpGroups();
        setUpChildren();
    }

    private void setUpChildren() {
        Line line = new Line(10,10, 200, 10);
        line.setStrokeWidth(4f);
        line.setStroke(Color.rgb(37, 180, 30));
        line.setStrokeLineCap(StrokeLineCap.ROUND);

        sideBarInfo = new SideBarInfo();
        StackPane sideBarInfoPane = new StackPane(sideBarInfo);
        sideBarInfoPane.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(line, channels, users, payment, notifications, sideBarInfoPane);
    }

    private void setUpGroups() {
        channels = new GroupSideBarItem("Channels");
        users = new GroupSideBarItem("Users");
        payment = new GroupSideBarItem("Payment");
        notifications = new GroupSideBarItem("Notifications");
        setUpItems();
    }

    private void setUpItems() {
        SideBarItem cancel = new SideBarItem("Cancel", new Logo(Logo.Type.CANCEL), tabs.get("Cancel"));
        SideBarItem add = new SideBarItem("Add", new Logo(Logo.Type.ADD), tabs.get("Add"));
        SideBarItem done = new SideBarItem("Done", new Logo(Logo.Type.DONE), tabs.get("Done"));
        SideBarItem aboutUs = new SideBarItem("About Us", new Logo(Logo.Type.ABOUT_US), tabs.get("About Us"));
        SideBarItem user = new SideBarItem("User", new Logo(Logo.Type.USER), tabs.get("User"));
        SideBarItem close = new SideBarItem("Close", new Logo(Logo.Type.CLOSE), tabs.get("Close"));
        SideBarItem deleteAll = new SideBarItem("Delete All", new Logo(Logo.Type.DELETE_ALL), tabs.get("deleteAll"));
        SideBarItem help = new SideBarItem("Help", new Logo(Logo.Type.HELP), tabs.get("Help"));
        SideBarItem next = new SideBarItem("Next", new Logo(Logo.Type.NEXT), tabs.get("Next"));
        SideBarItem previous = new SideBarItem("Previous", new Logo(Logo.Type.PREVIOUS), tabs.get("Previous"));
        SideBarItem remove = new SideBarItem("Remove", new Logo(Logo.Type.REMOVE), tabs.get("Remove"));
        current = cancel;
        channels.addItems(cancel, add, done);
        users.addItems(aboutUs, user, close, deleteAll);
        payment.addItems(help, next);
        notifications.addItems(previous, remove);
    }
}

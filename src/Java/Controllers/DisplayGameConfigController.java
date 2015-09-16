package Java.Controllers;


import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Java.Objects.Player;
import Java.Objects.MuleGame;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AveryDingler on 9/10/15.
 */

public class DisplayGameConfigController implements Initializable {

    private MuleGame muleGame;

//    @FXML //fx: id display
//    private Label display;

    @FXML private GridPane thePane;


    public void initialize(URL url, ResourceBundle rb) {
        //display.setText(muleGame.map.getTileValues(0,0));
    }

    public void setMuleGame(MuleGame mulegame) {
        this.muleGame = mulegame;
    }

//    public void displayTile() {
//        display.setText(muleGame.map.getTileValues(0,0));
//    }

    public void start() {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 9; k++) {
                Button button = new Button();
                button.setPrefWidth(Double.MAX_VALUE);
                button.setPrefHeight(Double.MAX_VALUE);
                //String url = "/resources/images/" + muleGame.getMap().getTile(i, k) + ".jpg";
                //String hoverUrl = "/resources/images/" + muleGame.getMap().getTile(i, k) + "_hover.jpg";
                button.setId(muleGame.getMap().getTile(i, k));
                //button.setStyle("-fx-background-image: url(" + url + ")");
                button.getStylesheets().addAll(this.getClass().getResource("/resources/style/style.css").toExternalForm());

                /*
                button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        button.setStyle("-fx-background-image: url(" + hoverUrl + ")");
                    }
                });

                button.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        button.setStyle("-fx-background-image: url(" + url + ")");
                    }
                });
                */

                // attempting to make a menu appear when a tile is clicked - would be best to made a pane (or new window)
                // for each tile, and then this method calls to it
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        StackPane pane = new StackPane();
                        Rectangle r = new Rectangle();
                        r.setX(100);
                        r.setY(100);
                        r.setWidth(100);
                        r.setHeight(100);
                        pane.getChildren().add(r);
                        thePane.getChildren().add(pane);
                    }
                });

                thePane.add(button, i, k);
            }
        }
    }
}



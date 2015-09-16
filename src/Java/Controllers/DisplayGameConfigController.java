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
import javafx.scene.text.Text;
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

                thePane.add(button, i, k);
            }
        }
    }
}



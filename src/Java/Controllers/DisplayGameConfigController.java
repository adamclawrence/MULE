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
import Java.Objects.Tile;
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
    private int selectingRound = 1;
    private int selectingPlayer = 0;
    private int numSkipped = 0;

//    @FXML //fx: id display
//    private Label display;

    @FXML private GridPane thePane;
    @FXML private Label currentPlayerLabel;
    @FXML private Button skipButton;


    public void initialize(URL url, ResourceBundle rb) {
        //display.setText(muleGame.map.getTileValues(0,0));
        System.out.println("BLJDSLKFJLSDKFJL:");
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

                // attempting to make a menu appear when a tile is clicked - would be best to made a pane (or new window)
                // for each tile, and then this method calls to it
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
//                        StackPane pane = new StackPane();
//                        Rectangle r = new Rectangle();
//                        r.setX(100);
//                        r.setY(100);
//                        r.setWidth(100);
//                        r.setHeight(100);
//                        pane.getChildren().add(r);
//                        thePane.getChildren().add(pane);
                        purchaseLand(muleGame.getPlayers()[selectingPlayer], button);
                    }
                });

                thePane.add(button, i, k);
            }
        }
        currentPlayerLabel.setText(muleGame.getPlayers()[selectingPlayer].getName() + " Money Remaining: " + muleGame.getPlayers()[selectingPlayer].getMoney());
    }

//    public void landSelectionStart() {
//        int selectionRound = 0;
//        int Player = 0;
//
//        for (int x = 0; x < 2; x ++) {
//            for (int y = 0; y < (muleGame.getPlayers().length); y++) {
//                Player selectingPlayer = muleGame.getPlayers()[y];
//                currentPlayerLabel.setText(selectingPlayer.getName() + " Money Remaining: " + selectingPlayer.getMoney());
//            }
//        }
//    }

//    public void playerSelectLand(int selectionRound, int PlayerNum) {
//        boolean freeRound = false;
//        if (selectionRound <= 2) {
//            freeRound = true;
//        }
//        Player selectingPlayer = muleGame.getPlayers()[PlayerNum];
//
//    }

    public void skipSelection() {
        if (selectingRound <=2) {
            numSkipped = 0;
        } else {
            numSkipped++;
        }

        if (selectingPlayer == muleGame.getPlayers().length - 1) {
            selectingRound++;
            selectingPlayer = 0;
            if (numSkipped == muleGame.getPlayers().length) {
                System.out.println("ALL SKIPPED END SELECTION PHASE!");
            } else {
                numSkipped = 0;
            }
        } else {
            selectingPlayer++;
        }
        currentPlayerLabel.setText(muleGame.getPlayers()[selectingPlayer].getName()
                + " Money Remaining: " + muleGame.getPlayers()[selectingPlayer].getMoney());
    }

    public void purchaseLand(Player player, Button button) {
        int price;
        if (selectingRound <= 2) {
            price = 0;
            numSkipped = 0;
        } else {
            price = 50; // this line needs to be changed to actual price of the tile
        }
        //Add a popup window here that says
        //"Do you want to purchase this land for {price}"
        //if yes, run following code
        //if no, return

        String color = player.getColor().substring(2);
        button.setStyle("-fx-background-color: #" + color);
        player.setMoney(player.getMoney() - price);
        //set the tile to be owned by player
        if (selectingPlayer == muleGame.getPlayers().length - 1) {
            selectingRound++;
            selectingPlayer = 0;
            if (numSkipped == muleGame.getPlayers().length) {
                System.out.println("ALL SKIPPED END SELECTION PHASE!");
            } else {
                numSkipped = 0;
            }
        } else {
            selectingPlayer++;
        }

        currentPlayerLabel.setText(muleGame.getPlayers()[selectingPlayer].getName()
                + " Money Remaining: " + muleGame.getPlayers()[selectingPlayer].getMoney());


    }
}



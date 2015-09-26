package Java.Controllers; /**
 * Sample Skeleton for 'Round.fxml' Controller Class
 */

import Java.Objects.MuleGame;
import Java.Objects.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoundController implements Initializable {

    @FXML // fx:id="player1Name"
    private Label player1Name; // Value injected by FXMLLoader

    @FXML // fx:id="p3Image"
    private ImageView p3Image; // Value injected by FXMLLoader

    @FXML // fx:id="roundNumber"
    private Label roundNumber; // Value injected by FXMLLoader

    @FXML // fx:id="p1Image"
    private ImageView p1Image; // Value injected by FXMLLoader

    @FXML // fx:id="player2Name"
    private Label player2Name; // Value injected by FXMLLoader

    @FXML // fx:id="player3Name"
    private Label player3Name; // Value injected by FXMLLoader

    @FXML // fx:id="p2Image"
    private ImageView p2Image; // Value injected by FXMLLoader

    @FXML // fx:id="p4Image"
    private ImageView p4Image; // Value injected by FXMLLoader

    @FXML // fx:id="player4Name"
    private Label player4Name; // Value injected by FXMLLoader

    @FXML
    private Button continueButton;

   // private int current = -1;
    private MapController mapController;
    private MuleGame muleGame;
    private Stage stage;
    private int skips;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setSkips(int skips) { this.skips = skips; }

    public void setStage(Stage stage) { this.stage =stage;}

    public void setMuleGame(MuleGame mulegame) {
        this.muleGame = mulegame;
    }

   // public void setCurrent(int current) { this.current = current % muleGame.getPlayers().length; }

    public void start() {

        muleGame.arrangePlayers();
        if (!muleGame.selectionRound) {
            System.out.println("It is " + muleGame.getPlayers()[muleGame.getCurrentPlayer()].toString() + "'s turn!");
        } else {
            System.out.println("Next is a land selection");
        }
       //Image human = new Image(".." + File.separator + ".." + File.separator + "resources" + File.separator + "images" + File.separator + "human.jpg");
        Image human = new Image("/images/human.jpg");
        Image flapper = new Image("/images/flapper.jpg");
        Image other = new Image("/images/other.gif");
        roundNumber.setText("ROUND: " + Integer.toString(muleGame.getRound()));
        ImageView[] images = {p1Image, p2Image, p3Image, p4Image};
        Player[] players = muleGame.getPlayers();
        Label[] playerNames = {player1Name, player2Name, player3Name, player4Name};
        for (int x = 0; x < players.length; x++) {
            if (players[x].getRace().contains("Human")) {
                images[x].setImage(human);
            } else if (players[x].getRace().contains("Flapper")) {
                images[x].setImage(flapper);
            } else {
                images[x].setImage(other);
            }
            playerNames[x].setText(players[x].getName());
        }
        updatePlayerScores();
        continueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/Map.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {

                }
                Parent p = loader.getRoot();
                ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(p));
                mapController = loader.getController();
                mapController.setMuleGame(muleGame);
                mapController.setSkips(skips);
                mapController.setStage(stage);
                mapController.start();
                stage.show();
            }
        });
    }

    private void updatePlayerResources() {
        //calculate player
    }
    private void updatePlayerScores() {
        //display money, score, and energy on screen

    }
}

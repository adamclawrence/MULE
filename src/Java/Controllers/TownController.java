package Java.Controllers;

/**
 * Created by Brian on 9/17/2015.
 */

import Java.Objects.MuleGame;
import Java.Objects.Pub;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class TownController implements Initializable {
    @FXML
    public Button pub_button;

    @FXML
    private Button assay_office_button;

    @FXML
    private Button land_office_button;

    @FXML
    private Button shop_button;

    @FXML
    private Button back_button;

    private Stage stage;
    private MapController mapController;
    private MuleGame muleGame;
   // private int current;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

  //  public void setCurrent(int current) {
   //     this.current = current;
  //  }

    public void start(MapController dGCC, MuleGame mG, Stage s) {
        this.mapController = dGCC;
        this.muleGame = mG;
        this.stage = s;

        if (mapController == null) {
            System.out.println("display game config controller");
        }
        if (muleGame == null) {
            System.out.println("mule game");
        }

        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/Map.fxml"));
                try {
                    loader.load();
                    Parent p = loader.getRoot();
                    ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(p));
                    mapController = loader.getController();
                    mapController.setMuleGame(muleGame);
                    mapController.setStage(stage);
                    mapController.start();
                    stage.show();
                    System.out.println("CANNOT GO BACK");
                } catch(Exception e) {
                }

            }
        });
        pub_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                muleGame.t.cancel();
                Pub p = new Pub();
                System.out.println(muleGame.timeRemaining);
                int bonus = p.gamble(muleGame.timeRemaining, muleGame.getRound());
                muleGame.getPlayers()[muleGame.getCurrentPlayer()].addMoney(bonus);
                System.out.println("Gambled for: " + bonus);
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/Round.fxml"));
                    loader.load();
                    Parent par = loader.getRoot();
                    //((Node)event.getSource()).getScene().getWindow();
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(par));
                    RoundController roundController = loader.getController();
                    if (muleGame.getCurrentPlayer() == (muleGame.getPlayers().length - 1)) {
                        muleGame.setCurrentPlayer(0);
                        muleGame.selectionRound = true;
                        muleGame.incRound();
                    } else {
                        muleGame.incCurrentPlayer();
                    }
                    roundController.setMuleGame(muleGame);
                  //  roundController.setCurrent(current++);
                    roundController.setStage(stage);
                    roundController.start();
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e + "THERE WAS AN ERROR WITH THE LOADER");
                }
            }
        });
    }
}

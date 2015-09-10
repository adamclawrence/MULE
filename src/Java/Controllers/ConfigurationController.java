package Java.Controllers;

/**
 * Sample Skeleton for 'Configuration.fxml' Controller Class
 */

import Java.Objects.MuleGame;
import Java.Objects.Player;
import Java.Objects.Map;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConfigurationController implements Initializable{

//    @FXML // ResourceBundle that was given to the FXMLLoader
//    private ResourceBundle resources;
//
//    @FXML // URL location of the FXML file that was given to the FXMLLoader
//    private URL location;

    @FXML // fx:id="selectPlayers"
    private ChoiceBox<Integer> selectPlayers; // Value injected by FXMLLoader

    @FXML // fx:id="selectMap"
    private ChoiceBox<String> selectMap; // Value injected by FXMLLoader

    @FXML
    public ChoiceBox<String> selectDifficulty;

    @FXML // fx:id="startGame"
    private Button startGame; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL url, ResourceBundle rb) {
        selectMap.getItems().addAll("Map1", "Map2", "Map3");
        selectPlayers.getItems().addAll(1,2,3,4);
        selectDifficulty.getItems().addAll("Beginner");
        selectDifficulty.getSelectionModel().selectFirst();
    }

    public void switchToPlayers(ActionEvent event) throws IOException {
        Player[] players = new Player[selectPlayers.getValue()];
        Map map = new Map(selectMap.getValue());
        MuleGame muleGame = new MuleGame(selectDifficulty.getValue(), map, players);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Java/AddPlayer.fxml"));
        loader.load();
        Parent p = loader.getRoot();

        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        AddPlayerController addPlayerController = loader.getController();
        addPlayerController.setMuleGame(muleGame);
        stage.show();
    }


    public Player generatePlayer(int playerNumber) {
        return new Player("Player " + playerNumber, "Human", selectDifficulty.getValue());
    }
}

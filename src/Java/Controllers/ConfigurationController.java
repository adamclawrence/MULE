package Java.Controllers;

/**
 * Sample Skeleton for 'Configuration.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class ConfigurationController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="selectPlayers"
    private ChoiceBox<Integer> selectPlayers; // Value injected by FXMLLoader

    @FXML // fx:id="selectMap"
    private ChoiceBox<String> selectMap; // Value injected by FXMLLoader

    @FXML
    private ChoiceBox<String> selectDifficulty;

    @FXML // fx:id="startGame"
    private Button startGame; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert selectPlayers != null : "fx:id=\"selectPlayers\" was not injected: check your FXML file 'Configuration.fxml'.";
        assert selectMap != null : "fx:id=\"selectMap\" was not injected: check your FXML file 'Configuration.fxml'.";
        assert startGame != null : "fx:id=\"startGame\" was not injected: check your FXML file 'Configuration.fxml'.";
        assert selectDifficulty != null: "fx:id=\"startGame\" was not injected: check your FXML file 'Configuration.fxml'.";
        selectMap.getItems().addAll("Map1", "Map2", "Map3");
        selectPlayers.getItems().addAll(1,2,3,4);
        selectDifficulty.getItems().addAll("Beginner");
        selectDifficulty.getSelectionModel().selectFirst();
        startGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("---NEW MULE GAME---");
                System.out.println("MAP: " + selectMap.getValue());
                System.out.println("PLAYERS: " +  selectPlayers.getValue());
                System.out.println("DIFFICULTY: " + selectDifficulty.getValue());

            }
        });

    }
}

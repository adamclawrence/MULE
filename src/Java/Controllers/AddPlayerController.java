package Java.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

/**
 * Created by AveryDingler on 9/9/15.
 */
public class AddPlayerController {
    @FXML
    public ToggleGroup raceGroup;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Button finishPlayer;
    @FXML
    public Label playerNumber;

    @FXML
    void initialize() {
        assert playerNumber != null : "fx:id=\"playerNumber\" was not injected: check your FXML file 'AddPlayer.fxml'.";
        assert raceGroup != null : "fx:id=\"raceGroup\" was not injected: check your FXML file 'AddPlayer.fxml'.";
        assert colorPicker != null : "fx:id=\"colorPicker\" was not injected: check your FXML file 'AddPlayer.fxml'.";
        assert finishPlayer != null : "fx:id=\"finishPlayer\" was not injected: check your FXML file 'AddPlayer.fxml'.";

    }
}



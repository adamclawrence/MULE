package Java.Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import Java.Objects.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import Java.Objects.Player;
import Java.Objects.MuleGame;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AveryDingler on 9/9/15.
 */
public class AddPlayerController implements Initializable{
    @FXML
    public ToggleGroup raceGroup;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Button finishPlayer;
    @FXML
    public Label playerNumber;
    @FXML
    public Text currentMap;
    @FXML
    public Text currentDifficulty;
    @FXML
    private TextField newName;

    private MuleGame muleGame;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setMuleGame(MuleGame muleGame) {
        //Helpful Video https://www.youtube.com/watch?v=Vh7XDjWlm_w
        currentDifficulty.setText(muleGame.getDifficulty());
        currentMap.setText(muleGame.getMap().getName());
        playerNumber.setText("PLAYER 1");
        this.muleGame = muleGame;
    }

    public void addPlayer(ActionEvent event) throws IOException {
        int x = nextNull(muleGame.getPlayers());
        if (x == 10) {
            return;
        } else {
            muleGame.players[x] = new Player(newName.getText(), raceGroup.getSelectedToggle().toString(), muleGame.getDifficulty());
            System.out.println(Arrays.toString(muleGame.getPlayers()));
            if (muleGame.players[(muleGame.getPlayers().length) - 1] != null) {
                System.out.println("exit!");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Java/DisplayGameConfig.fxml"));
                loader.load();
                Parent p = loader.getRoot();
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                DisplayGameConfigController displayGameConfigController = loader.getController();
                displayGameConfigController.setMuleGame(muleGame);
                stage.show();

            } else {
                newName.clear();
                playerNumber.setText("PLAYER " + (x + 2));
            }
        }
    }

    private int nextNull(Player[] players) {
        for (int x = 0; x < players.length; x++) {
            if (players[x] == null) {
                return x;
            }
        }
        return 10;
    }

}



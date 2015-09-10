package Java.Controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Java.Objects.Player;
import Java.Objects.MuleGame;
import javafx.scene.text.Text;

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
    public ListView addedPlayers;
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
        this.muleGame = muleGame;
    }

}



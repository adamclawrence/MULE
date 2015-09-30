package Java.Controllers;

import javafx.fxml.FXML;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Adam on 9/29/2015.
 */
public class StoreController implements Initializable {
    @FXML
    public Button food_button;

    @FXML
    private Button energy_button;

    @FXML
    private Button smithore_button;

    @FXML
    private Button crystite_button;

    @FXML
    private Button mule_button;

    private Stage stage;
    private MapController mapController;
    private MuleGame muleGame;
    // private int current;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void start(MapController dGCC, MuleGame mG, Stage s) {
        this.mapController = dGCC;
        this.muleGame = mG;
        this.stage = s;
        food_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //if user has money
                //give user x amount of item
                //if user doesn't have money
                //give dialog warning

            }
        });

    }
}

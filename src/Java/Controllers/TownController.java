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
    private Button pub_button;

    @FXML
    private Button assay_office_button;

    @FXML
    private Button land_office_button;

    @FXML
    private Button shop_button;

    @FXML
    private Button back_button;

    private Stage stage;
    private DisplayGameConfigController displayGameConfigController;
    private MuleGame muleGame;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void start(DisplayGameConfigController dGCC, MuleGame mG, Stage s) {
        this.displayGameConfigController = dGCC;
        this.muleGame = mG;
        this.stage = s;

        if (displayGameConfigController == null) {
            System.out.println("display game config controller");
        }
        if (muleGame == null) {
            System.out.println("mule game");
        }

        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Java/DisplayGameConfig.fxml"));
                try {
                    loader.load();
                    Parent p = loader.getRoot();
                    ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(p));
                    displayGameConfigController = loader.getController();
                    displayGameConfigController.setMuleGame(muleGame);
                    displayGameConfigController.setStage(stage);
                    stage.show();
                    System.out.println("CANNOT GO BACK");
                } catch(Exception e) {
                }

            }
        });
        pub_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            Pub p = new Pub();
                int bonus = p.gamble(10, 2);
                System.out.println(bonus);

            }
        });
    }
}

package Java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Configuration.fxml"));
        //Parent addPlayer = FXMLLoader.load(getClass().getResource("AddPlayer.fxml"));
        currentStage.setTitle("NightHawks M.U.L.E");
        currentStage.setScene(new Scene(root, 600, 400));
        currentStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

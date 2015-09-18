package Java;

import Java.Objects.Map;
import io.github.jgkamat.JayLayer.JayLayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //javadoc
        //http://jgkamat.github.io/JayLayer/doc/jay/jaysound/JayLayer.html
        JayLayer sound = new JayLayer("/audio/", "/audio/");
        int playlistNum = sound.createPlaylist(true);
        sound.addToPlaylist(playlistNum, "Boyfriend.mp3");
        sound.addToPlaylist(playlistNum, "No Tellin'.mp3");
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Configuration.fxml"));
        currentStage.setTitle("NightHawks M.U.L.E");
        currentStage.setScene(new Scene(root, 600, 400));
        currentStage.show();
        sound.startPlaylist(0);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void run() {
        Map map = new Map("default");
        map.printTiles();
    }
}

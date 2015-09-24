package Java;

import Java.Objects.Map;
import io.github.jgkamat.JayLayer.JayLayer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    Stage currentStage;
    JayLayer sound;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        //javadoc
        //http://jgkamat.github.io/JayLayer/doc/jay/jaysound/JayLayer.html
//        sound = new JayLayer("/audio/", "/audio/");
//        int playlistNum = sound.createPlaylist(true);
//        sound.addToPlaylist(playlistNum, "No Tellin'.mp3");
//        sound.addToPlaylist(playlistNum, "Boyfriend.mp3");
//        sound.addSoundEffect("fart.mp3");
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Configuration.fxml"));
        currentStage.setTitle("NightHawks M.U.L.E");
        currentStage.setScene(new Scene(root, 600, 400));
        currentStage.show();
        //sound.startPlaylist(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

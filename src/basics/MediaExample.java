/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaExample extends Application {
    @Override
    public void start(Stage stage) {
        Media media = new Media("file:/home/mlewis/workspace/JavaFXTesting/20150513_141448.mp4");
        MediaPlayer player = new MediaPlayer(media);
        MediaView viewer = new MediaView(player);
        viewer.setRotate(90);
        viewer.setPreserveRatio(true);
        Button playButton = new Button("Play");
        playButton.setOnAction(eh -> {
            if(player.getStatus() == MediaPlayer.Status.PLAYING) {
                playButton.textProperty().set("Play");
                player.pause();
            } else {
                playButton.textProperty().set("Pause");
                player.play();
            }
        });
        Group root = new Group(viewer);
        root.getChildren().add(playButton);
        Scene scene = new Scene(root,720,500);
        playButton.layoutXProperty().bind(scene.widthProperty().subtract(playButton.widthProperty()).divide(2));
        viewer.fitWidthProperty().bind(scene.widthProperty());
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

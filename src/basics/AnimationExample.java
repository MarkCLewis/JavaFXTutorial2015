/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExample extends Application {
    
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Rectangle rectangle = new Rectangle(100,100);
        rectangle.setLayoutY(250);
        RotateTransition rt = new RotateTransition();
        rt.setByAngle(360);
        rt.setCycleCount(5);
        rt.setAutoReverse(true);
        rt.setDuration(Duration.seconds(3));
        TranslateTransition tt = new TranslateTransition();
        tt.setByX(500);
        tt.setCycleCount(5);
        tt.setAutoReverse(true);
        tt.setDuration(Duration.seconds(3));
        ParallelTransition pt = new ParallelTransition(rectangle,rt,tt);
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
        pt.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

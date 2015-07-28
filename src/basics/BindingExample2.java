/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Show how math can be used in a binding.
 * 
 * @author Mark Lewis
 */
public class BindingExample2 extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(200,200);
        Group root = new Group(rectangle);
        Scene scene = new Scene(root, 800, 500);
        rectangle.layoutXProperty().bind(scene.widthProperty().subtract(rectangle.widthProperty()).divide(2));
        rectangle.layoutYProperty().bind(scene.heightProperty().subtract(rectangle.heightProperty()).divide(2));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

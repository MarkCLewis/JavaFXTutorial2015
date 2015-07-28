/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Link a slider and a text field to something that is drawn
 * 
 * @author Mark Lewis
 */
public class BindingExample3 extends Application{
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(200,200);
        Slider slider = new Slider(0,400,200);
        Text text = new Text();
        text.textProperty().bind(slider.valueProperty().asString());
        text.layoutYProperty().set(50);
        rectangle.widthProperty().bind(slider.valueProperty());
        rectangle.heightProperty().bind(slider.valueProperty());
        Group root = new Group(rectangle,slider,text);
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

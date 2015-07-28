/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EventsExample extends Application {
    
    @Override
    public void start(Stage stage) {
        Rectangle keyControl = new Rectangle(100,100);
        keyControl.setFill(Color.RED);
        Rectangle mouseControl = new Rectangle(100,100);
        mouseControl.setFill(Color.BLUE);
        Button button = new Button("Reset");
        button.setOnAction(event -> {
            keyControl.layoutXProperty().set(0);
            keyControl.layoutYProperty().set(0);
            mouseControl.layoutXProperty().set(0);
            mouseControl.layoutYProperty().set(0);
        });
        Group root = new Group(keyControl,mouseControl,button);
        Scene scene = new Scene(root,500,500);
        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
            case LEFT:
                keyControl.layoutXProperty().set(keyControl.layoutXProperty().get()-5);
                break;
            case RIGHT:
                keyControl.layoutXProperty().set(keyControl.layoutXProperty().get()+5);
                break;
            case UP:
                keyControl.layoutYProperty().set(keyControl.layoutYProperty().get()-5);
                break;
            case DOWN:
                keyControl.layoutYProperty().set(keyControl.layoutYProperty().get()+5);
                break;
            default:
                break;
            }
        });
        scene.setOnMouseMoved(event -> {
            mouseControl.layoutXProperty().set(event.getX());
            mouseControl.layoutYProperty().set(event.getY());
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

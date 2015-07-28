/*
 * Created on Jul 27, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneGraphExample extends Application {
    
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(200,200,200,200);
        rectangle.setFill(Color.AQUA);
        Text text = new Text("You should use JavaFX for all your JVM GUI needs.");
        text.setLayoutY(500);
        Line line = new Line(800,0,400,800);
        line.setStroke(Color.CHOCOLATE);
        line.setStrokeWidth(5);
        Group grouping = new Group();
        grouping.setRotate(45);
        ImageView iv = new ImageView(new Image("file:PIA17171.jpg"));
        grouping.getChildren().add(iv);
        Group root = new Group();
        root.getChildren().add(grouping);
        root.getChildren().add(rectangle);
        root.getChildren().add(text);
        root.getChildren().add(line);
        Scene scene = new Scene(root,800,800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

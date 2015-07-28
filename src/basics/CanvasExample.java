/*
 * Created on Jul 28, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExample extends Application {
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(600,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        canvas.setOnMousePressed(event -> {
            gc.moveTo(event.getX(), event.getY());
        });
        canvas.setOnMouseDragged(event -> {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        });
        Group root = new Group(canvas);
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

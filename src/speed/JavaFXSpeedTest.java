/*
 * Created on Jul 29, 2015
 */
package speed;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXSpeedTest extends Application {
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800,800);
        canvas.setOnMouseClicked(event -> {
            drawStuff(canvas.getGraphicsContext2D());
        });
        Group root = new Group(canvas);
        Scene scene = new Scene(root,800,800,false,SceneAntialiasing.BALANCED);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void drawStuff(GraphicsContext gc) {
        long start = System.nanoTime();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 800, 800);
        gc.setFill(Color.BLACK);
        for(int i=0; i<1000000; ++i) {
            double size = Math.random()*2;
            gc.fillOval(Math.random()*800, Math.random()*800, size, size);
        }
        System.out.println("Circles "+(System.nanoTime()-start)/1e9);
        start = System.nanoTime();
        gc.setStroke(Color.RED);
        gc.beginPath();
        for(int i=0; i<10000; ++i) {
            gc.moveTo(Math.random()*800, Math.random()*800);
            gc.lineTo(Math.random()*800, Math.random()*800);
        }
        gc.closePath();
        gc.stroke();
        System.out.println("Lines "+(System.nanoTime()-start)/1e9);
    }
}

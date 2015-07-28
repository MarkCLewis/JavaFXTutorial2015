/*
 * Created on Jul 25, 2015
 */
package basics;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class BasicJavaFXEvents extends Application {
    private int count = 0;
    
    @Override
    public void start(Stage stage) {
        Button button = new Button("Increment");
        Label counter = new Label(Integer.toString(count));
        button.setOnAction(ae -> {
            count++;
            counter.setText(Integer.toString(count));
        });
        GridPane root = new GridPane();
        root.add(button, 0, 0);
        root.add(counter, 1, 0);
        GridPane.setVgrow(button, Priority.ALWAYS);
        GridPane.setHalignment(counter, HPos.RIGHT);
        GridPane.setHgrow(counter, Priority.ALWAYS);
//        button.prefHeightProperty().bind(root.heightProperty());
        Scene scene = new Scene(root,200,50);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

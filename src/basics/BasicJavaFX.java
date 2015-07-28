/*
 * Created on Jul 25, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BasicJavaFX extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me");
        Scene scene = new Scene(button,500,500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

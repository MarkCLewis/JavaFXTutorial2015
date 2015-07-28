/*
 * Created on Jul 28, 2015
 */
package basics;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Simple3DExample extends Application {
    @Override
    public void start(Stage stage) {
        stage.show();
    }
    public static void main(String[] args) {
        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
        launch(args);
    }
}

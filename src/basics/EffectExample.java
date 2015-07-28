/*
 * Created on Jul 28, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EffectExample extends Application {
    
    @Override
    public void start(Stage stage) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setColor(Color.BLACK);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        Text text = new Text("This text has a shadow");
        text.setLayoutY(200);
        text.setFill(Color.CRIMSON);
        text.setEffect(shadow);
        text.setFont(Font.font(40));
        Group root = new Group(text);
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

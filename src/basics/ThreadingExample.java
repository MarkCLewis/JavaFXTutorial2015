/*
 * Created on Jul 28, 2015
 */
package basics;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ThreadingExample extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(100, 100);
        Button badButton = new Button("Bad grow");
        badButton.setOnAction(event -> {
            try {
                Thread.sleep(5000);
                rectangle.setWidth(rectangle.getWidth() * 1.2);
                rectangle.setHeight(rectangle.getHeight() * 1.2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Button goodButton = new Button("Good shrink");
        goodButton.setOnAction(event -> {
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    Platform.runLater(() -> {
                        rectangle.setWidth(rectangle.getWidth() / 1.2);
                        rectangle.setHeight(rectangle.getHeight() / 1.2);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });
        HBox buttons = new HBox(badButton, goodButton);
        buttons.alignmentProperty().set(Pos.CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10));
        BorderPane root = new BorderPane();
        root.setCenter(rectangle);
        root.setBottom(buttons);
        Scene scene = new Scene(root, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

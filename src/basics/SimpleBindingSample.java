/*
 * Created on May 11, 2015
 */
package basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleBindingSample extends Application {
    @Override
    public void start(Stage stage) {
        Text text = new Text("Testing. I think that the text might wrap around if it gets long enough. So I will type in another sentence.");
        text.layoutYProperty().set(200);
        text.wrappingWidthProperty().set(500);
//        text.wrappingWidthProperty().bind(stage.widthProperty());
        Group root = new Group(text);
        Scene scene = new Scene(root,500,500);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

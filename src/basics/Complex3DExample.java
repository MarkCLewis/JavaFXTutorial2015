/*
 * Created on Jul 28, 2015
 */
package basics;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.PickResult;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Complex3DExample extends Application {
    @Override
    public void start(Stage stage) {
        Sphere sphere = new Sphere(200);
        sphere.setTranslateX(300);
        sphere.setTranslateY(300);
        sphere.setRotationAxis(new Point3D(0,-1,0));
        Camera camera = new PerspectiveCamera();
        PhongMaterial material = new PhongMaterial();
        Image img = new Image("file:BookCover.png");
        WritableImage writeImg = new WritableImage(img.getPixelReader(), (int)img.getWidth(), (int)img.getHeight());
        sphere.setMaterial(material);
        material.setDiffuseMap(writeImg);
        
        Group root = new Group(sphere,camera);
        SubScene subScene = new SubScene(root, 600, 550);
        subScene.setCamera(camera);
        subScene.setOnMouseDragged(event -> {
            PickResult pr = event.getPickResult();
            if(pr.getIntersectedNode() == sphere) {
                PixelWriter pw = writeImg.getPixelWriter();
                Point2D textIntersect = pr.getIntersectedTexCoord();
                pw.setColor((int)(textIntersect.getX()*writeImg.getWidth()), (int)(textIntersect.getY()*writeImg.getHeight()), Color.GREEN);
            }
        });
        
        Slider rotateSlider = new Slider(-180,180,0);
        sphere.rotateProperty().bind(rotateSlider.valueProperty());
        Slider distSlider = new Slider(0,500,200);
        sphere.translateZProperty().bind(distSlider.valueProperty());
        
        HBox sliders = new HBox(new Label("Rotate:"),rotateSlider,new Label("Distance"),distSlider);
        VBox vbox = new VBox(subScene, sliders);
        Scene scene = new Scene(vbox,600,600);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

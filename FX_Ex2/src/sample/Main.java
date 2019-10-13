package sample;

import Point_Ex.AxisOrientation;
import com.sun.javafx.geom.Vec3d;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import java.awt.*;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.canvas.Canvas;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Canvas canvas = new Canvas(300,300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillOval(130, 17, 5, 5);

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
//        Rotate rotate = new Rotate();

        Sphere sphere = new Sphere(50);
        sphere.setMaterial(redMaterial);
        sphere.setTranslateX(0);
        sphere.setTranslateY(0);
        sphere.setTranslateZ(0);

        Sphere sphere2 = new Sphere(5);
        sphere2.setMaterial(redMaterial);
        sphere2.setTranslateX(-100);
        sphere2.setTranslateY(-10);
        sphere2.setTranslateZ(-20);

        PointLight light = new PointLight();
        light.setTranslateX(0);
        light.setTranslateY(50);
        light.setTranslateZ(-200);
        light.setVisible(true);

        AxisOrientation axisOrientation = new AxisOrientation(200);

        Point3D point3DA = new Point3D(1,1,1);
        Point3D point3DB = new Point3D(100,100,100);
        Cylinder cylinder = paintCylinder(point3DA, point3DB);

        Group root2 = new Group(axisOrientation, sphere,sphere2, light,cylinder);
        root2.getChildren().add(canvas);

        PerspectiveCamera camera = new PerspectiveCamera(false);

//        root2.getTransforms().add(rotate);
//        matrixRotateNode(root2,0,10,10);
        final int[] x1 = {10,10,10,0,0,0};
        Scene scene = new Scene(root2, 500, 475,true);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().getName().equals("Q")) {
                    x1[0] -= 10;
                    camera.setTranslateX(x1[0]);
                }
                if(keyEvent.getCode().getName().equals("W")) {
                    x1[0] += 10;
                    camera.setTranslateX(x1[0]);
                }
                if(keyEvent.getCode().getName().equals("A")) {
                    x1[1] -= 10;
                    camera.setTranslateY(x1[1]);
                }
                if(keyEvent.getCode().getName().equals("S")) {
                    x1[1] += 10;
                    camera.setTranslateY(x1[1]);
                }
                if(keyEvent.getCode().getName().equals("Z")) {
                    x1[2] -= 10;
                    camera.setTranslateZ(x1[2]);
                }
                if(keyEvent.getCode().getName().equals("X")) {
                    x1[2] += 10;
                    camera.setTranslateZ(x1[2]);
                }
                if(keyEvent.getCode().getName().equals("E")) {
                    x1[3] += 1;
                    matrixRotateNode(root2,0,1+x1[3],0);
                }
                if(keyEvent.getCode().getName().equals("D")) {
                    x1[4] += 1;
                    matrixRotateNode(root2,0,0,1+x1[4]);
                }
                if(keyEvent.getCode().getName().equals("C")) {
                    x1[5] += 1;
                    matrixRotateNode(root2,1+x1[5],0,0);
                }
            }
        });
//        box.getTransforms().add(rotate);
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void matrixRotateNode(Node n, double alf, double bet, double gam){
        double A11=Math.cos(alf)*Math.cos(gam);
        double A12=Math.cos(bet)*Math.sin(alf)+Math.cos(alf)*Math.sin(bet)*Math.sin(gam);
        double A13=Math.sin(alf)*Math.sin(bet)-Math.cos(alf)*Math.cos(bet)*Math.sin(gam);
        double A21=-Math.cos(gam)*Math.sin(alf);
        double A22=Math.cos(alf)*Math.cos(bet)-Math.sin(alf)*Math.sin(bet)*Math.sin(gam);
        double A23=Math.cos(alf)*Math.sin(bet)+Math.cos(bet)*Math.sin(alf)*Math.sin(gam);
        double A31=Math.sin(gam);
        double A32=-Math.cos(gam)*Math.sin(bet);
        double A33=Math.cos(bet)*Math.cos(gam);

        double d = Math.acos((A11+A22+A33-1d)/2d);
        if(d!=0d){
            double den=2d*Math.sin(d);
            Point3D p= new Point3D((A32-A23)/den,(A13-A31)/den,(A21-A12)/den);
            n.setRotationAxis(p);
            n.setRotate(Math.toDegrees(d));
        }
    }

    public Cylinder paintCylinder(Point3D A, Point3D B) {
        Point3D temp = A.subtract(B);
        double Y = temp.getX() != 0 || temp.getZ() != 0 ? B.getY() : B.getY() > A.getY() ? B.getY() : A.getY();

        Point3D dir = A.subtract(B).crossProduct(new Point3D(0, -1, 0));

        double angle = Math.acos(A.subtract(B).normalize().dotProduct(new Point3D(0, -1, 0)));

        double h1 = A.distance(B);

        Cylinder c = new Cylinder(20d, h1);

        c.getTransforms().addAll(new Translate(B.getX(), Y - h1 / 2d, B.getZ()),
                new Rotate(-Math.toDegrees(angle), 0d, h1 / 2d, 0d, new Point3D(dir.getX(), -dir.getY(), dir.getZ())));

        return c;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

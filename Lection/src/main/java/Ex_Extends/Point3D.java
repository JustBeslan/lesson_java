package Ex_Extends;

import java.awt.*;
import java.awt.geom.Point2D;

public class Point3D extends Point2D {
    public double x;
    public double у;
    public double z;

    Point3D(double x, double y, double z){
        this.x = x;
        this.у = у;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.у;
    }

    public void setLocation(double x, double y) {

    }
}

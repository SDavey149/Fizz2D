package Phys2d;

import java.io.Serializable;

public final class Vector2D implements Serializable {
    public double x, y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this(v.x, v.y);
    }

    public void set(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(double val) {
        this.x = val;
        this.y = val;
    }

    public boolean equals(Object o) {
        if (o instanceof Vector2D) {
            Vector2D v = (Vector2D) o;
            return x == v.x && y == v.y;
        } else
            return false;
    }

    public double mag() {
        return Math.hypot(x, y);
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    // angle of difference vector between this vector and other vector
    public double angle(Vector2D other) {
        return Math.atan2(other.y - y, other.x - x);
    }

    public String toString() {
        return "(" + String.format("%.09f", x) + "," + String.format("%.09f", y)
                + ")";
    }

    public void add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void addScaled(Vector2D v, double fac) {
        this.x += v.x * fac;
        this.y += v.y * fac;
    }

    public void mult(double fac) {
        this.x *= fac;
        this.y *= fac;
    }

    public void rotate(double theta) {
        double xn = x * Math.cos(theta) - y * Math.sin(theta);
        double yn = x * Math.sin(theta) + y * Math.cos(theta);
        x = xn;
        y = yn;
    }

    public double scalarProduct(Vector2D v) {
        return x * v.x + y * v.y;
    }

    public double dist(Vector2D v) {
        return Math.hypot(x - v.x, y - v.y);
    }

    public void normalise() {
        double len = mag();
        x /= len;
        y /= len;
    }

    public void divide(double operand) {
        x = x/operand;
        y = y/operand;

    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public static Vector2D minus(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector2D rotate90degreesAnticlockwise() {
        return new Vector2D(-y,x);
    }
}

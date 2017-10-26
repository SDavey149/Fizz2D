package io.scottd.fizz2d.model;

public final class Vector2 {
    public double x, y;

    public Vector2() {
        this(0, 0);
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 v) {
        this(v.x, v.y);
    }

    public void set(Vector2 v) {
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
        if (o instanceof Vector2) {
            Vector2 v = (Vector2) o;
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
    public double angle(Vector2 other) {
        return Math.atan2(other.y - y, other.x - x);
    }

    public String toString() {
        return "(" + String.format("%.09f", x) + "," + String.format("%.09f", y)
                + ")";
    }

    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void addScaled(Vector2 v, double fac) {
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

    public double scalarProduct(Vector2 v) {
        return x * v.x + y * v.y;
    }

    public double dist(Vector2 v) {
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

    public static Vector2 minus(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector2 rotate90degreesAnticlockwise() {
        return new Vector2(-y,x);
    }

    public void elementWiseMult(Vector2 multiplier) {
        this.x = this.x*multiplier.x;
        this.y = this.y*multiplier.y;
    }
}

package Phys2d;

import utilities.Vector2;

/**
 * Created by scottdavey on 06/03/2016.
 */
public class Line extends Shape {

    private double length;
    private int thickness;

    public Line(GameObject obj, double length, int thickness) {
        super(obj);
        this.length = length;
        this.thickness = thickness;
    }

    public static Line getLineObject(Vector2 start, Vector2 end) {
        Vector2 midpoint = new Vector2(start);
        start.mult(-1);
        end.add(start);
        Vector2 line = end; //rename to line

        Vector2 half = new Vector2(line);
        half.mult(0.5);
        midpoint.add(half);

        //get angle to xaxis
        double rotation = Math.atan2(line.y, line.x);
        GameObject obj = new GameObject(midpoint, null);
        obj.rotate(rotation);
        return new Line(obj, line.mag(), 1);

    }

    @Override
    public boolean overlaps(Shape shape) {
        if (shape instanceof Circle) {
            return overlapWith((Circle)shape);
        }
        return false;
    }

    private boolean overlapWith(Circle circle) {
        Vector2 start = startOfLine();
        Vector2 tangent = Vector2.minus(endOfLine(), start);
        double length = tangent.mag();
        tangent.normalise();
        Vector2 normal = tangent.rotate90degreesAnticlockwise();

        Vector2 lineToC = Vector2.minus(circle.object.getPosition(), start);
        double distNormal = Math.abs(lineToC.scalarProduct(normal));
        double distLine = lineToC.scalarProduct(tangent);
        return distNormal <= circle.getRadius() && distLine >= 0 && distLine <= length;
    }


    public Vector2 startOfLine() {
        double startX = object.getPosition().x - length/2;
        double startY = object.getPosition().y;
        Vector2 start = new Vector2(startX, startY);
        Vector2 rotationVec = object.getRotation();
        double rotation = Math.atan2(rotationVec.y, rotationVec.x);
        if (rotation == 0) {
            return start;
        }
        Vector2 pos = new Vector2(object.getPosition());
        pos.mult(-1);
        start.add(pos);
        start.rotate(rotation);
        pos.mult(-1);
        start.add(pos);
        return start;
    }

    public Vector2 endOfLine() {
        double endX = object.getPosition().x + length/2;
        double endY = object.getPosition().y;
        Vector2 end = new Vector2(endX, endY);
        Vector2 rotationVec = object.getRotation();
        double rotation = Math.atan2(rotationVec.y, rotationVec.x);
        if (rotation == 0) {
            return end;
        }
        Vector2 pos = new Vector2(object.getPosition());
        pos.mult(-1);
        end.add(pos);
        end.rotate(rotation);
        pos.mult(-1);
        end.add(pos);
        return end;
    }
}

package Phys2d;

import utilities.Vector2;

import java.util.ArrayList;

/**
 * Created by scottdavey on 13/04/2016.
 */
public class Polygon extends Shape {

    ArrayList<Line> lines;

    public Polygon(GameObject obj) {
        super(obj);
        lines = new ArrayList<>();
    }

    public void moveTo(Vector2 start, Vector2 end) {
        Line line = Line.getLineObject(start, end);
        lines.add(line);
    }

    public void moveTo(Vector2 destination) {
        Line lastLine = lines.get(lines.size()-1);
        Line line = Line.getLineObject(lastLine.endOfLine(), destination);
        lines.add(line);
    }

    @Override
    public boolean overlaps(Shape shape) {
        for (Line line : lines) {
            if (line.overlaps(shape)) {
                return true;
            }
        }
        return false;
    }

}

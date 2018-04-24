package io.scottd.fizz2ddemos.views.gameObjects;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2ddemos.IGameComponent;

import java.awt.*;

public class Line extends GameObjectComponent implements IGameComponent {
    private Vector2 start;
    private Vector2 end;

    public Line(double xScale, double yScale, int yMaxResolution, Vector2 start, Vector2 end) {
        super(xScale, yScale, yMaxResolution);
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawLine(
                getScreenXFromGameX(start.x),
                getScreenYFromGameY(start.y),
                getScreenXFromGameX(end.x),
                getScreenYFromGameY(end.y)
                );
    }
}

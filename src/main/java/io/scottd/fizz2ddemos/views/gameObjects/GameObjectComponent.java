package io.scottd.fizz2ddemos.views.gameObjects;

import io.scottd.fizz2ddemos.IGameComponent;

import java.awt.*;

public abstract class GameObjectComponent implements IGameComponent {
    protected double xScale, yScale;
    private int yMaxResolution;

    public GameObjectComponent(double xScale, double yScale, int yMaxResolution) {
        this.xScale = xScale;
        this.yScale = yScale;
        this.yMaxResolution = yMaxResolution;
    }

    protected int getScreenXFromGameX(double gameX) {
        return (int)(gameX * xScale);
    }

    protected int getScreenYFromGameY(double gameY) {
        return (int)(yMaxResolution - gameY * yScale);
    }
}

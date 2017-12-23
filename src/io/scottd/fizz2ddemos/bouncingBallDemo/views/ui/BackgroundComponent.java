package io.scottd.fizz2ddemos.bouncingBallDemo.views.ui;


import io.scottd.fizz2ddemos.bouncingBallDemo.views.IGameComponent;

import java.awt.*;

/**
 * Created by scottdavey on 07/06/2017.
 */
public class BackgroundComponent implements IGameComponent
{
    private Color backgroundColor;
    private int sizeX, sizeY;

    public BackgroundComponent(Color backgroundColour, int sizeX, int sizeY) {
        this.backgroundColor = backgroundColour;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, sizeX, sizeY);
    }
}

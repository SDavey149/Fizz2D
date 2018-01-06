package io.scottd.fizz2ddemos.bouncingBallDemo.views.ui;

import io.scottd.fizz2ddemos.bouncingBallDemo.views.IGameComponent;

import java.awt.*;

/**
 * Created by scottdavey on 07/06/2017.
 */
public class FpsTextComponent implements IGameComponent {
    private long lastDrawTime;
    private int xPos, yPos;

    public FpsTextComponent(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawString("30", xPos, yPos);
    }
}

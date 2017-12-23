package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.model.Vector2;
import io.scottd.fizz2ddemos.bouncingBallDemo.views.AbstractGameView;
import io.scottd.fizz2ddemos.bouncingBallDemo.views.ui.BackgroundComponent;

import java.awt.*;

/**
 * Created by scottdavey on 07/06/2017.
 */
public class BouncingBallView extends AbstractGameView {
    private int resolutionX, resolutionY;
    Vector2 scale;

    public BouncingBallView(int resolutionX, int resolutionY, Vector2 scale) {
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        this.scale = scale;
        setupGameComponents();
    }

    @Override
    public void setupGameComponents() {
        registerGameComponent(new BackgroundComponent(Color.BLACK, resolutionX, resolutionY));
    }
}

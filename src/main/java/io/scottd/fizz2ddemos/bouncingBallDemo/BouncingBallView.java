package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2ddemos.AbstractGameView;
import io.scottd.fizz2ddemos.views.BackgroundComponent;

import java.awt.*;

/**
 * Created by scottdavey on 07/06/2017.
 */
public class BouncingBallView extends AbstractGameView{

    public BouncingBallView(int resolutionX, int resolutionY, Vector2 scale) {
        super(resolutionX, resolutionY, scale);
        setupGameComponents();
    }

    @Override
    public void setupGameComponents() {
        registerGameComponent(new BackgroundComponent(Color.BLACK, resolutionX, resolutionY));
    }
}

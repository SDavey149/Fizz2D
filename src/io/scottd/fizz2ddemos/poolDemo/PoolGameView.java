package io.scottd.fizz2ddemos.poolDemo;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2ddemos.AbstractGameView;
import io.scottd.fizz2ddemos.views.BackgroundComponent;

import java.awt.*;

public class PoolGameView extends AbstractGameView {

    public PoolGameView(int resolutionX, int resolutionY, Vector2 scale) {
        super(resolutionX, resolutionY, scale);
    }

    @Override
    public void setupGameComponents() {
        registerGameComponent(new BackgroundComponent(Color.BLACK, resolutionX, resolutionY));
    }
}
package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.integrators.ImprovedEulers;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerController extends MouseAdapter {

    private BouncingBallsDemo game;

    public PlayerController(BouncingBallsDemo game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Vector2 position = new Vector2(e.getX(), game.resolutionY-e.getY());
        position.divide(game.viewScale);
        game.setupBall(position, new Vector2(0, 0), new ImprovedEulers(), Color.GREEN);
    }
}

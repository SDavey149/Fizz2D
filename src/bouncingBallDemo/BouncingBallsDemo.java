package bouncingBallDemo;

import bouncingBallDemo.views.AbstractGameView;
import bouncingBallDemo.views.game.Ball;
import fizz2d.world.integrators.ImprovedEulers;
import fizz2d.world.World;
import utilities.JEasyFrame;
import utilities.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    public World world;
    public AbstractGameView view;
    private static final long TIME_BETWEEN_FRAME = 1000/60;

    public static void main(String[] args) {
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        Vector2 worldSize = new Vector2(80,60);
        world = new World(worldSize);
        Vector2 viewScale = new Vector2(800/worldSize.x,
                            600/worldSize.y);
        view = new BouncingBallView(800, 600,
                viewScale);
        setupGame(viewScale);
    }

    public void gameLoop() {
        Thread gameThread = new Thread(new GameLoopRunnable(world, view));
        gameThread.start();
    }

    private void setupGame(Vector2 scale) {
        Ball ball = new Ball(scale.x, scale.y, Color.CYAN);
        ball.getParticle().getPosition().set(30, 30);
        ball.getParticle().getVelocity().set(5, 0);
        ball.getParticle().addRepeatableForce(new Vector2(0, -10));

        Ball ball2 = new Ball(scale.x, scale.y, Color.RED);
        ball2.getParticle().getPosition().set(70, 30);
        ball2.getParticle().getVelocity().set(5, 0);
        ball2.getParticle().addRepeatableForce(new Vector2(0, -10));
        ball2.setIntegrator(new ImprovedEulers());

        world.addGameObjects(ball.getParticles());
        world.addGameObjects(ball2.getParticles());
        view.registerGameComponent(ball);
        view.registerGameComponent(ball2);
    }

}

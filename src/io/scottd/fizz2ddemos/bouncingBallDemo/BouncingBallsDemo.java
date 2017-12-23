package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.force_generator.ConstantParticleForceGenerator;
import io.scottd.fizz2d.model.Vector2;
import io.scottd.fizz2d.world.World;
import io.scottd.fizz2d.world.integrators.Eulers;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2d.world.integrators.ImprovedEulers;
import io.scottd.fizz2ddemos.bouncingBallDemo.views.AbstractGameView;
import io.scottd.fizz2ddemos.bouncingBallDemo.views.game.Ball;
import io.scottd.fizz2ddemos.utils.JEasyFrame;

import java.awt.*;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo {
    public World world;
    public AbstractGameView view;
    private Vector2 viewScale;

    private static final int RESOLUTION_X = 800;
    private static final int RESOLUTION_Y = 600;

    public static void main(String[] args) {
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        Vector2 worldSize = new Vector2(80,60);
        world = new World(worldSize);
        viewScale = new Vector2(RESOLUTION_X/worldSize.x,
                            RESOLUTION_Y /worldSize.y);
        view = new BouncingBallView(RESOLUTION_X, RESOLUTION_Y,
                viewScale);
        setupGame();
    }

    public void gameLoop() {
        Thread gameThread = new Thread(new GameLoopRunnable(world, view));
        gameThread.start();
    }

    private void setupGame() {
        setupBall(new Vector2(70, 30), new Vector2(5, 0), new ImprovedEulers(), Color.RED);
        setupBall(new Vector2(30, 30), new Vector2(5, 0), new Eulers(), Color.BLUE);
    }

    private void setupBall(Vector2 initialPosition, Vector2 initialVelocity, IUpdateIntegrator integrator, Color color) {
        Ball ball = new Ball(viewScale.x, viewScale.y, color, RESOLUTION_Y);
        ball.getParticle().getPosition().set(initialPosition);
        ball.getParticle().getVelocity().set(initialVelocity);
        ball.setIntegrator(integrator);
        world.registerParticleForceGenerator(ball.getParticle(), new ConstantParticleForceGenerator(new Vector2(0, -9.8)));
        world.addGameObjects(ball.getParticles());
        view.registerGameComponent(ball);
    }

}

package bouncingBallDemo;

import bouncingBallDemo.views.AbstractGameView;
import bouncingBallDemo.views.game.Ball;
import fizz2d.particle.GravityParticleForceGenerator;
import fizz2d.particle.IParticleForceGenerator;
import fizz2d.world.integrators.Eulers;
import fizz2d.world.integrators.IUpdateIntegrator;
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
    private Vector2 viewScale;

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
        viewScale = new Vector2(800/worldSize.x,
                            600/worldSize.y);
        view = new BouncingBallView(800, 600,
                viewScale);
        setupGame();
    }

    public void gameLoop() {
        Thread gameThread = new Thread(new GameLoopRunnable(world, view));
        gameThread.start();
    }

    private void setupGame() {
        Ball ball2 = new Ball(viewScale.x, viewScale.y, Color.RED);
        ball2.getParticle().getPosition().set(70, 30);
        ball2.getParticle().getVelocity().set(5, 0);
        ball2.setIntegrator(new ImprovedEulers());
        setupBall(new Vector2(70, 30), new Vector2(5, 0), new ImprovedEulers(), Color.RED);
        setupBall(new Vector2(30, 30), new Vector2(5, 0), new Eulers(), Color.BLUE);
    }

    private void setupBall(Vector2 initialPosition, Vector2 initialVelocity, IUpdateIntegrator integrator, Color color) {
        Ball ball = new Ball(viewScale.x, viewScale.y, color);
        ball.getParticle().getPosition().set(initialPosition);
        ball.getParticle().getVelocity().set(initialVelocity);
        ball.setIntegrator(integrator);
        world.registerParticleForceGenerator(ball.getParticle(), new GravityParticleForceGenerator());
        world.addGameObjects(ball.getParticles());
        view.registerGameComponent(ball);
    }

}//30, 30, 5, 0

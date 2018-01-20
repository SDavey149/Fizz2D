package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.collision.ElasticParticleContactResolver;
import io.scottd.fizz2d.collision.ParticleContactDetector;
import io.scottd.fizz2d.force_generator.ConstantParticleForceGenerator;
import io.scottd.fizz2d.force_generator.ParticleForceRegistry;
import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.force_generator.ParticleSpringForceGenerator;
import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.world.World;
import io.scottd.fizz2d.world.WorldConfiguration;
import io.scottd.fizz2d.world.integrators.Eulers;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2d.world.integrators.ImprovedEulers;
import io.scottd.fizz2ddemos.GameLoopRunnable;
import io.scottd.fizz2ddemos.AbstractGameView;
import io.scottd.fizz2ddemos.bouncingBallDemo.views.Ball;
import io.scottd.fizz2ddemos.JEasyFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo implements MouseListener {
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
        WorldConfiguration config = CreateWorldConfiguration();
        world = new World(config);
        viewScale = new Vector2(RESOLUTION_X/config.worldSize.x,
                            RESOLUTION_Y /config.worldSize.y);
        view = new BouncingBallView(RESOLUTION_X, RESOLUTION_Y,
                viewScale);
        view.addMouseListener(this);
        setupGame();
    }

    private WorldConfiguration CreateWorldConfiguration() {
        WorldConfiguration config = new WorldConfiguration();
        config.worldSize = new Vector2(80, 60);
        config.particleForceRegistry = new ParticleForceRegistry();
        config.eulerUpdates = 10;
        config.particleContactDetector = ParticleContactDetector.getInstance();
        config.particleContactResolver = new ElasticParticleContactResolver();
        return config;
    }

    public void gameLoop() {
        Thread gameThread = new Thread(new GameLoopRunnable(world, view));
        gameThread.start();
    }

    private void setupGame() {
        Ball ball1 = setupBall(new Vector2(48, 30), new Vector2(0, 0), new ImprovedEulers(), Color.RED);
        Ball ball2 = setupBall(new Vector2(30, 30), new Vector2(0, 0), new Eulers(), Color.BLUE);

        Particle p1 = ball1.getParticle();
        Particle p2 = ball2.getParticle();
        world.registerParticleForceGenerator(p1, new ParticleSpringForceGenerator(p2, 3, 15));
        world.registerParticleForceGenerator(p2, new ParticleSpringForceGenerator(p1, 3, 15));
    }

    private Ball setupBall(Vector2 initialPosition, Vector2 initialVelocity, IUpdateIntegrator integrator, Color color) {
        Ball ball = new Ball(viewScale.x, viewScale.y, color, RESOLUTION_Y);
        ball.getParticle().getPosition().set(initialPosition);
        ball.getParticle().getVelocity().set(initialVelocity);
        ball.setIntegrator(integrator);
        world.registerParticleForceGenerator(ball.getParticle(), new ConstantParticleForceGenerator(new Vector2(0, -9.8)));
        world.addGameObjects(ball.getParticles());
        view.registerGameComponent(ball);
        return ball;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Vector2 position = new Vector2(e.getX(), RESOLUTION_Y-e.getY());
        position.divide(viewScale);
        setupBall(position, new Vector2(0, 0), new ImprovedEulers(), Color.GREEN);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

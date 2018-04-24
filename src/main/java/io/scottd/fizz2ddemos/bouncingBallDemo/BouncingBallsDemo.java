package io.scottd.fizz2ddemos.bouncingBallDemo;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.contact.ContactDetectorRegistry;
import io.scottd.fizz2d.contact.ParticleContactDetector;
import io.scottd.fizz2d.force_generator.AnchoredSpringForceGenerator;
import io.scottd.fizz2d.force_generator.ConstantParticleForceGenerator;
import io.scottd.fizz2d.force_generator.ParticleForceRegistry;
import io.scottd.fizz2d.world.Particle;
import io.scottd.fizz2d.world.WorldConfiguration;
import io.scottd.fizz2d.world.integrators.Eulers;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2d.world.integrators.ImprovedEulers;
import io.scottd.fizz2ddemos.AbstractGameDemo;
import io.scottd.fizz2ddemos.JEasyFrame;
import io.scottd.fizz2ddemos.views.gameObjects.Ball;
import io.scottd.fizz2ddemos.views.gameObjects.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by scottdavey on 11/04/2017.
 */
public final class BouncingBallsDemo extends AbstractGameDemo implements MouseListener {

    public static void main(String[] args) {
        BouncingBallsDemo demo = new BouncingBallsDemo();
        JEasyFrame frame = new JEasyFrame(demo.view, "Bouncing Ball Demo");
        frame.setSize(800, 625);
        demo.gameLoop();
    }

    private BouncingBallsDemo() {
        super();
        view.addMouseListener(this);
    }

    @Override
    protected WorldConfiguration createWorldConfiguration() {
        WorldConfiguration config = new WorldConfiguration();
        config.worldSize = new Vector2(80, 60);
        config.particleForceRegistry = new ParticleForceRegistry();
        config.eulerUpdates = 10;

        config.contactDetectorRegistry = ContactDetectorRegistry.getInstance();
        config.contactDetectorRegistry.registerContactDetector(new ParticleContactDetector());
        return config;
    }

    @Override
    protected void setupGame() {
        //Ball ball1 = setupBall(new Vector2(48, 30), new Vector2(-5, 0), new ImprovedEulers(), Color.RED);
        Ball ball2 = setupBall(new Vector2(30, 32), new Vector2(0, 0), new Eulers(), Color.BLUE);

        //Particle p1 = ball1.getParticle();
        Particle p2 = ball2.getParticle();
        //TODO: Anchor point and ball at same point breaks stuff - write a test for this
        world.registerParticleForceGenerator(p2, new AnchoredSpringForceGenerator(
                new Vector2(30, 30), 2, 2));
        Line line = new Line(viewScale.x, viewScale.y, RESOLUTION_Y, new Vector2(30, 30),
                p2.getPosition());
        view.registerGameComponent(line);
        //world.registerParticleForceGenerator(p2, new ParticleSpringForceGenerator(p1, 3, 15));
    }

    private Ball setupBall(Vector2 initialPosition, Vector2 initialVelocity, IUpdateIntegrator integrator, Color color) {
        Ball ball = new Ball(viewScale.x, viewScale.y, RESOLUTION_Y, color);
        Particle particle = ball.getParticle();
        particle.getPosition().set(initialPosition);
        particle.getVelocity().set(initialVelocity);
        particle.setIntegrator(integrator);

        world.registerParticleForceGenerator(ball.getParticle(),
                new ConstantParticleForceGenerator(new Vector2(0, -9.8)));
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
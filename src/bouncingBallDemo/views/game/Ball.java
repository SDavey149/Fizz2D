package bouncingBallDemo.views.game;

import bouncingBallDemo.views.IGameComponent;
import fizz2d.model.Particle;
import fizz2d.model.integrators.IUpdateIntegrator;
import utilities.Vector2;

import java.awt.*;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Ball implements IGameComponent, IGameObject {
    private double xScale, yScale;
    private Particle particle;
    private Color color;

    public Ball(double xScale, double yScale, Color color) {
        particle = new Particle(2, 1);
        particle.getPosition().set(30, 30);
        particle.getVelocity().set(new Vector2(5, 0));
        particle.addRepeatableForce(new Vector2(0, -10));
        this.xScale = xScale;
        this.yScale = yScale;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        int x = (int) (particle.getPosition().x * xScale);
        int y = (int) (600 - particle.getPosition().y * yScale);
        g.setColor(color);
        double radius = particle.getRadius() * Math.min(yScale, xScale);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    public void setIntegrator(IUpdateIntegrator integrator) {
        particle.setIntegrator(integrator);
    }

    @Override
    public Particle[] getParticles() {
        return new Particle[]{particle};
    }
}

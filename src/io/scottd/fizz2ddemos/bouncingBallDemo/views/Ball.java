package io.scottd.fizz2ddemos.bouncingBallDemo.views;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2ddemos.IGameComponent;
import io.scottd.fizz2ddemos.IGameObject;

import java.awt.*;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Ball implements IGameComponent, IGameObject {
    private double xScale, yScale;
    private Particle particle;
    private Color color;
    private int yMaxResolution;

    public Ball(double xScale, double yScale, Color color, int yMaxResolution) {
        particle = new Particle(2, 1);
        this.xScale = xScale;
        this.yScale = yScale;
        this.color = color;
        this.yMaxResolution = yMaxResolution;
    }

    public Particle getParticle() {
        return particle;
    }

    @Override
    public void draw(Graphics2D g) {
        int x = (int) (particle.getPosition().x * xScale);
        int y = (int) (yMaxResolution - particle.getPosition().y * yScale);
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

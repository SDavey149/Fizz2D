package io.scottd.fizz2ddemos.views.gameObjects;

import io.scottd.fizz2d.world.Particle;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2ddemos.IGameComponent;
import io.scottd.fizz2ddemos.IGameObject;

import java.awt.*;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Ball extends GameObjectComponent implements IGameComponent, IGameObject {
    private Particle particle;
    private Color color;

    public Ball(double xScale, double yScale, int yMaxResolution, Color color) {
        super(xScale, yScale, yMaxResolution);
        particle = new Particle(2, 1);
        this.color = color;
    }

    public Particle getParticle() {
        return particle;
    }

    @Override
    public void draw(Graphics2D g) {
        int x = getScreenXFromGameX(particle.getPosition().x);
        int y = getScreenYFromGameY(particle.getPosition().y);
        g.setColor(color);
        double radius = particle.getRadius() * Math.min(yScale, xScale);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    @Override
    public Particle[] getParticles() {
        return new Particle[]{particle};
    }
}

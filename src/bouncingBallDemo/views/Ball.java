package bouncingBallDemo.views;

import fizz2d.model.Particle;
import utilities.Vector2D;

import java.awt.*;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Ball implements IGameObjectView {
    private double xScale, yScale;
    private Particle particle;

    public Ball(double xScale, double yScale) {
        particle = new Particle(10);
    }

    @Override
    public void draw(Graphics2D g) {
        int x =
    }

    @Override
    public Particle getParticle() {
        return particle;
    }
}

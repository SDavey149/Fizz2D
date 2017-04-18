package bouncingBallDemo.views;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
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
        particle = new Particle(2, 1);
        particle.getPosition().set(30, 30);
        particle.getVelocity().set(new Vector2D(5,0));
        particle.addRepeatableForce(new Vector2D(0, -10));
        this.xScale = xScale;
        this.yScale = yScale;
    }

    @Override
    public void draw(Graphics2D g) {
        int x = (int) (particle.getPosition().x*xScale);
        int y = (int) (600-particle.getPosition().y*yScale);
        g.setColor(Color.CYAN);
        double radius = particle.getRadius()*Math.min(yScale, xScale);
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
    }

    @Override
    public Particle getParticle() {
        return particle;
    }
}

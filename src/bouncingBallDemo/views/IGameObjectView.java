package bouncingBallDemo.views;

import fizz2d.model.Particle;

import java.awt.*;

/**
 * Created by scottdavey on 16/04/2017.
 */
public interface IGameObjectView {
    void draw(Graphics2D g);

    Particle getParticle();
}

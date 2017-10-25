package world.integrators;

import particle.Particle;

/**
 * Created by scottdavey on 16/04/2017.
 */
public interface IUpdateIntegrator {
    void update(double delta, Particle p);
}
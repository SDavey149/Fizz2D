package io.scottd.fizz2d.world.integrators;

import io.scottd.fizz2d.world.Particle;

/**
 * Created by scottdavey on 16/04/2017.
 */
public interface IUpdateIntegrator {
    void update(double delta, Particle p);
}

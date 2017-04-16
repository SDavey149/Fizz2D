package fizz2d.model.integrators;

import fizz2d.model.Particle;

/**
 * Created by scottdavey on 16/04/2017.
 */
public interface IUpdateIntegrator {
    void update(double delta, Particle p);
}

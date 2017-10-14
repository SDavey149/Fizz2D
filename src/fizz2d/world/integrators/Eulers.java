package fizz2d.world.integrators;

import fizz2d.particle.Particle;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Eulers implements IUpdateIntegrator {
    @Override
    public void update(double delta, Particle p) {
        if (Double.isInfinite(p.getInverseMass())) {
            return;
        }

        p.getPosition().addScaled(p.getVelocity(), delta);
        p.getVelocity().addScaled(p.getAcceleration(), delta);
    }
}

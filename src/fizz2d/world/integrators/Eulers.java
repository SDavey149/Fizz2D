package fizz2d.world.integrators;

import fizz2d.model.Particle;

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
        imposeDrag(delta, p);
        p.getForceAccumulated().set(0);
    }

    private void imposeDrag(double delta, Particle p) {
        p.getVelocity().mult(Math.pow(p.getDrag(), delta));
    }
}

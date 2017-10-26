package io.scottd.fizz2d.world.integrators;

import io.scottd.fizz2d.model.Vector2;
import io.scottd.fizz2d.particle.Particle;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class ImprovedEulers implements IUpdateIntegrator {
    @Override
    public void update(double delta, Particle p) {
        if (Double.isInfinite(p.getInverseMass())) {
            return;
        }

        updateAcceleration(p);
        updatePositionAndVelocity(delta, p);
    }

    private void updateAcceleration(Particle p) {
        if (p.getForceAccumulated().mag() <= 0) {
            return;
        }

        Vector2 acceleration = new Vector2();
        acceleration.addScaled(p.getForceAccumulated(), p.getInverseMass());
        p.getAcceleration().set(acceleration);
    }

    private void updatePositionAndVelocity(double delta, Particle p) {
        Vector2 positionCopy = new Vector2(p.getPosition());
        Vector2 velocityCopy = new Vector2(p.getVelocity());
        Vector2 acceleration = new Vector2(p.getAcceleration());

        positionCopy.addScaled(p.getVelocity(), delta);
        velocityCopy.addScaled(p.getAcceleration(), delta);

        //step ahead
        velocityCopy.add(p.getVelocity());
        velocityCopy.mult(0.5);

        //constant acceleration is not always true, needs changing and researching
        acceleration.add(p.getAcceleration());
        acceleration.mult(0.5);

        p.getPosition().addScaled(velocityCopy, delta);
        p.getVelocity().addScaled(acceleration, delta);
    }
}

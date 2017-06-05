package fizz2d.model.integrators;

import fizz2d.model.Particle;
import utilities.Vector2D;

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

        Vector2D acceleration = new Vector2D();
        acceleration.addScaled(p.getForceAccumulated(), p.getInverseMass());
        p.getAcceleration().set(acceleration);
    }

    private void updatePositionAndVelocity(double delta, Particle p) {
        Vector2D positionCopy = new Vector2D(p.getPosition());
        Vector2D velocityCopy = new Vector2D(p.getVelocity());
        Vector2D acceleration = new Vector2D(p.getAcceleration());

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

        p.getForceAccumulated().set(0);

    }
}

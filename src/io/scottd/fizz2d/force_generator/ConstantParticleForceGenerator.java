package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.model.Vector2;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public class ConstantParticleForceGenerator implements IParticleForceGenerator {
    // We don't need to instantiate lots of gravity generators by accident
    private static int hashCode = 1;

    private Vector2 constantForce;

    public ConstantParticleForceGenerator(Vector2 constantForce) {
        this.constantForce = constantForce;
    }

    @Override
    public Vector2 getForce(Particle particle) {
        return constantForce;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantParticleForceGenerator) {
            return true;
        }
        return false;
    }
}

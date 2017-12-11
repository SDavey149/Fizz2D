package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.model.Vector2;


/**
 * Created by Scott Davey on 21/11/2017.
 */
public class ConstantParticleForceGeneratorFromPoint implements IParticleForceGenerator {
    private static int hashcode = 2;

    private double magnitude;
    private Vector2 point;

    public ConstantParticleForceGeneratorFromPoint(Vector2 point, double magnitude) {
        this.point = point;
        this.magnitude = magnitude;
    }

    @Override
    public Vector2 getForce(Particle particle) {
        Vector2 directionForce = Vector2.minus(particle.getPosition(), point);
        directionForce.normalise();
        directionForce.mult(magnitude);
        return directionForce;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantParticleForceGeneratorFromPoint) {
            return true;
        }
        return false;
    }
}

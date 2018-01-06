package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.model.Vector2;

import java.util.function.Predicate;


/**
 * Created by Scott Davey on 21/11/2017.
 */
public class ConstantParticleForceGeneratorFromPoint extends ForceGeneratorWithPredicate {
    private double magnitude;
    private Vector2 point;

    public ConstantParticleForceGeneratorFromPoint(Vector2 point, double magnitude) {
        super();
        setupFields(point, magnitude);
    }

    public ConstantParticleForceGeneratorFromPoint(Vector2 point, double magnitude, Predicate<Particle> predicate) {
        super(predicate);
        setupFields(point, magnitude);
    }

    private void setupFields(Vector2 point, double magnitude) {
        this.point = point;
        this.magnitude = magnitude;
    }

    @Override
    protected Vector2 getForceAfterPredicateCheck(Particle particle) {
        Vector2 directionForce = Vector2.minus(particle.getPosition(), point);
        directionForce.normalise();
        directionForce.mult(magnitude);
        return directionForce;
    }
}

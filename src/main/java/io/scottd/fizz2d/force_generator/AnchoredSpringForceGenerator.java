package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.Particle;

public class AnchoredSpringForceGenerator implements IParticleForceGenerator {
    protected Vector2 otherPoint;
    private double springConstant;
    private double restLength;

    public AnchoredSpringForceGenerator(Vector2 anchor, double springConstant, double restLength) {
        this(springConstant, restLength);
        this.otherPoint = anchor;
    }

    public AnchoredSpringForceGenerator(double springConstant, double restLength) {
        this.springConstant = springConstant;
        this.restLength = restLength;
    }

    @Override
    public Vector2 getForce(Particle particle) {
        Vector2 direction = Vector2.minus(particle.getPosition(), otherPoint);
        double lengthBetweenParticles = direction.mag();
        double lengthDelta = lengthBetweenParticles - restLength;
        double forceMagnitude = lengthDelta*springConstant;

        direction.normalise();
        direction.mult(-forceMagnitude);
        return direction;
    }
}

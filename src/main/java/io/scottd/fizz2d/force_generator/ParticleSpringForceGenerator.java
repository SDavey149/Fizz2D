package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.Particle;

public class ParticleSpringForceGenerator extends AnchoredSpringForceGenerator {
    private Particle otherParticle;

    public ParticleSpringForceGenerator(Particle otherParticle, double springConstant, double restLength) {
        super(springConstant, restLength);
        this.otherParticle = otherParticle;
    }

    @Override
    public Vector2 getForce(Particle particle) {
        otherPoint = otherParticle.getPosition();
        return super.getForce(particle);
    }
}

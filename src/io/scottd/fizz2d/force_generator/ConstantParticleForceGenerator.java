package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.model.Vector2;

import java.util.function.Predicate;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public class ConstantParticleForceGenerator extends ForceGeneratorWithPredicate {
    private Vector2 constantForce;

    public ConstantParticleForceGenerator(Vector2 constantForce) {
        super();
        this.constantForce = constantForce;
    }

    public ConstantParticleForceGenerator(Vector2 constantForce, Predicate<Particle> predicate) {
        super(predicate);
        this.constantForce = constantForce;
    }

    @Override
    protected Vector2 getForceAfterPredicateCheck(Particle particle) {
        return constantForce;
    }
}

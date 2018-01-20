package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.Vector2;

import java.util.function.Predicate;

public abstract class ForceGeneratorWithPredicate implements IParticleForceGenerator {
    private Predicate<Particle> predicate;

    public ForceGeneratorWithPredicate(Predicate<Particle> predicate) {
        this.predicate = predicate;
    }

    public ForceGeneratorWithPredicate() {
        this.predicate = p -> true;
    }

    @Override
    public Vector2 getForce(Particle particle) {
        if (!this.predicate.test(particle)) {
            return null;
        }

        return getForceAfterPredicateCheck(particle);
    }

    protected abstract Vector2 getForceAfterPredicateCheck(Particle particle);
}

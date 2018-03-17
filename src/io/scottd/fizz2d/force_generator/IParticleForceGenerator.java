package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.world.Particle;
import io.scottd.fizz2d.Vector2;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public interface IParticleForceGenerator {
    Vector2 getForce(Particle particle);
}

package io.scottd.fizz2d.world;

import io.scottd.fizz2d.collision.IParticleContactDetector;
import io.scottd.fizz2d.collision.IParticleContactResolver;
import io.scottd.fizz2d.force_generator.ParticleForceRegistry;
import io.scottd.fizz2d.Vector2;

/**
 * Created by Scott Davey on 03/04/2017.
 */
public class WorldConfiguration {
    public int eulerUpdates;
    public Vector2 worldSize;
    public IParticleContactDetector particleContactDetector;
    public IParticleContactResolver particleContactResolver;
    public ParticleForceRegistry particleForceRegistry;

}

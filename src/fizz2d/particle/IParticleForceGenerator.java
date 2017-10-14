package fizz2d.particle;

import utilities.Vector2;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public interface IParticleForceGenerator {
    Vector2 getForce(Particle particle);
}

package fizz2d.particle;

import utilities.Vector2;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public class GravityParticleForceGenerator implements IParticleForceGenerator {
    // We don't need to instantiate lots of gravity generators by accident
    private static int hashCode = 1;

    @Override
    public Vector2 getForce(Particle particle) {
        return new Vector2(0, -10);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GravityParticleForceGenerator) {
            return true;
        }
        return false;
    }
}

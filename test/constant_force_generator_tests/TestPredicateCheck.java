package constant_force_generator_tests;

import io.scottd.fizz2d.force_generator.ConstantParticleForceGenerator;
import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.Vector2;
import org.junit.Assert;
import org.junit.Test;

public class TestPredicateCheck {
    @Test
    public void testPredicateCheck_Failure() {
        Particle p = new Particle(1, 1);
        ConstantParticleForceGenerator generator = new ConstantParticleForceGenerator(
                new Vector2(2, 2), t -> t.getPosition().x == 5);

        Vector2 force = generator.getForce(p);
        Assert.assertNull(force);
    }

    @Test
    public void testPredicateCheck_Success() {
        Particle p = new Particle(1, new Vector2(5, 6), 1);
        ConstantParticleForceGenerator generator = new ConstantParticleForceGenerator(
                new Vector2(2, 2), t -> t.getPosition().x == 5);

        Vector2 force = generator.getForce(p);
        Assert.assertNotNull(force);
    }
}

package io.scottd.fizz2d.contact;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.contact.ElasticParticleContact;
import io.scottd.fizz2d.contact.IContactDetector;
import io.scottd.fizz2d.world.Particle;
import io.scottd.fizz2d.contact.Contact;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public class ParticleContactDetector implements IContactDetector {

    private static Contact createParticleContact(Particle p1, Particle p2) {
        Contact contact = new ElasticParticleContact(0.9);
        contact.particles = new Particle[] { p1, p2 };
        contact.collisionAngle = Vector2.minus(p2.getPosition(), p1.getPosition());
        contact.collisionAngle.normalise();
        return contact;
    }

    private static boolean hasCollided(Particle a, Particle b) {
        Vector2 particleAToB = Vector2.minus(a.getPosition(), b.getPosition());
        double separationVelocity = particleAToB.scalarProduct(Vector2.minus(a.getVelocity(), b.getVelocity()));
        if (separationVelocity > 0) {
            return false;
        }

        double combinedRadius = a.getRadius() + b.getRadius();
        return particleAToB.mag() < combinedRadius;
    }

    @Override
    public Contact getContact(Particle p1, Particle p2) {
        if (!hasCollided(p1, p2)) {
            return null;
        }

        return createParticleContact(p1, p2);
    }
}
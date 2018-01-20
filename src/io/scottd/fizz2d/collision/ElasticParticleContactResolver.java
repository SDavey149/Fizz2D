package io.scottd.fizz2d.collision;

import io.scottd.fizz2d.model.ParticleContact;
import io.scottd.fizz2d.model.Particle;
import io.scottd.fizz2d.Vector2;
import java.util.List;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public class ElasticParticleContactResolver implements IParticleContactResolver {
    private static double E = 0.9;
    @Override
    public void resolveParticleContacts(List<ParticleContact> particleContacts) {
        for (ParticleContact particleContact : particleContacts) {
            resolveParticleContact(particleContact);
        }
    }

    private void resolveParticleContact(ParticleContact contact) {
        Particle[] particles = contact.particles;
        double totalInverseMass = particles[0].getInverseMass() + particles[1].getInverseMass();
        double jb = (E+1)*(particles[0].getVelocity().scalarProduct(contact.collisionAngle)
                - particles[1].getVelocity().scalarProduct(contact.collisionAngle));
        jb /= totalInverseMass;

        //TODO: This needs cleaning up into a single method, DRY
        Vector2 velocityB = particles[1].getVelocity();
        Vector2 normalB = new Vector2(contact.collisionAngle);
        normalB.mult(jb * particles[1].getInverseMass());
        velocityB.add(normalB);

        Vector2 velocityA = particles[0].getVelocity();
        Vector2 normalA = new Vector2(contact.collisionAngle);
        normalA.mult(-1);
        normalA.mult(jb * particles[0].getInverseMass());
        velocityA.add(normalA);
    }
}

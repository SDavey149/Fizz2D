package collision;

import particle.Particle;
import model.Vector2;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 22/05/2017.
 */
public class ParticleContactDetector implements IParticleContactDetector {
    private static ParticleContactDetector particleContactDetector;

    public static ParticleContactDetector getInstance() {
        if (particleContactDetector == null) {
            particleContactDetector = new ParticleContactDetector();
        }
        return particleContactDetector;
    }

    private ParticleContactDetector() {
        //singleton
    }

    @Override
    public List<ParticleContact> getParticleToParticleContacts(List<Particle> particles) {
        List<ParticleContact> particleContacts = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            Particle p1 = particles.get(i);
            for (int j = 0; j < i; j++) {
                Particle p2 = particles.get(j);
                if (!hasCollided(p1, p2)) {
                    continue;
                }
                particleContacts.add(createParticleContact(p1, p2));
            }
        }
        return particleContacts;
    }

    private ParticleContact createParticleContact(Particle p1, Particle p2) {
        ParticleContact particleContact = new ParticleContact();
        particleContact.particles = new Particle[] { p1, p2 };
        particleContact.collisionAngle = Vector2.minus(p2.getPosition(), p1.getPosition());
        particleContact.collisionAngle.normalise();
        return particleContact;
    }

    private static boolean hasCollided(Particle a, Particle b) {
        Vector2 particleAToB = Vector2.minus(a.getPosition(), b.getPosition());
        double seperationVelocity = particleAToB.scalarProduct(Vector2.minus(a.getVelocity(), b.getVelocity()));
        if (seperationVelocity > 0) {
            return false;
        }

        double combinedRadius = a.getRadius() + b.getRadius();
        return particleAToB.mag() < combinedRadius;
    }
}

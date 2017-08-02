package fizz2d.collision;

import fizz2d.model.Particle;
import utilities.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Scott Davey on 22/05/2017.
 */
public class ParticleContactDetector {
    private List<Particle> particles;

    public ParticleContactDetector(List<Particle> particles) {
        this.particles = particles;
    }

    public List<ParticleContact> GetParticleContacts() {
        List<ParticleContact> particleContacts = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            for (int j = 0; j < i; j++) {
                Particle p1 = particles.get(i);
                Particle p2 = particles.get(j);
                if (!isPossibleCollision(p1, p2) || !hasCollided(p1, p2)) {
                    continue;
                }


            }
        }
        return particleContacts;
    }

    private static boolean isPossibleCollision(Particle a, Particle b) {
        double seperationVelocity = Vector2.minus(a.getPosition(), b.getPosition()).scalarProduct(
                Vector2.minus(a.getVelocity(), b.getVelocity()));
        return seperationVelocity < 0;
    }

    private static boolean hasCollided(Particle a, Particle b) {
        Vector2 particleAToB = Vector2.minus(a.getPosition(), b.getPosition());
        double combinedRadius = a.getRadius() + b.getRadius();
        return particleAToB.mag() < combinedRadius;
    }
}

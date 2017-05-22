package fizz2d.collision;

import fizz2d.model.Particle;
import utilities.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 22/05/2017.
 */
public class ParticleContactDetector {
    private ParticleContactDetector() {
    }

    public static List<ParticleContact> GetParticleContacts(List<Particle> particles) {
        List<ParticleContact> particleContacts = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            for (int j = 0; j < i; j++) {
                Particle p1 = particles.get(i);
                Particle p2 = particles.get(j);
                if (!isPossibleCollision(p1, p2)) {
                    continue;
                }


            }
        }
        return particleContacts;
    }

    private static boolean isPossibleCollision(Particle p1, Particle p2) {
        return movingTowardsEachOther(p1, p2);
    }

    private static boolean movingTowardsEachOther(Particle a, Particle b) {
        double seperationVelocity = Vector2.minus(a.getPosition(), b.getPosition()).scalarProduct(
                Vector2.minus(a.getVelocity(), b.getVelocity()));
        return seperationVelocity < 0;
    }
}

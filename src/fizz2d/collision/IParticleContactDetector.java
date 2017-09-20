package fizz2d.collision;

import fizz2d.model.Barrier;
import fizz2d.model.Particle;

import java.util.List;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public interface IParticleContactDetector {
    List<ParticleContact> getParticleToParticleContacts(List<Particle> particles);

    List<ParticleContact> getParticleToBarrierContacts(List<Particle> particles, List<Barrier> barriers);
}

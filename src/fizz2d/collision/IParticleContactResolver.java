package fizz2d.collision;

import java.util.List;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public interface IParticleContactResolver {
    void resolveParticleContacts(List<ParticleContact> particleContacts);
}

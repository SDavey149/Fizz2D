package io.scottd.fizz2d.collision;

import io.scottd.fizz2d.model.ParticleContact;

import java.util.List;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public interface IParticleContactResolver {
    void resolveParticleContacts(List<ParticleContact> particleContacts);
}

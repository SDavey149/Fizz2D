package io.scottd.fizz2d.force_generator;

import io.scottd.fizz2d.world.Particle;

import java.util.*;

/**
 * Created by Scott Davey on 14/10/2017.
 */
public class ParticleForceRegistry {
    private HashMap<IParticleForceGenerator, List<Particle>> particleForceGeneratorRegistry;

    public ParticleForceRegistry() {
        particleForceGeneratorRegistry = new HashMap<>();
    }

    public void registerParticle(Particle particle, IParticleForceGenerator forceGenerator) {
        if (particleForceGeneratorRegistry.containsKey(forceGenerator)) {
            particleForceGeneratorRegistry.get(forceGenerator).add(particle);
        } else {
            List<Particle> particles = new ArrayList<>();
            particles.add(particle);
            particleForceGeneratorRegistry.put(forceGenerator, particles);
        }
    }

    public void updateRegisteredForces() {
        for (Map.Entry<IParticleForceGenerator, List<Particle>> entry : particleForceGeneratorRegistry.entrySet()) {
            IParticleForceGenerator generator = entry.getKey();
            List<Particle> particles = entry.getValue();
            for (Particle particle : particles) {
                particle.addForce(generator.getForce(particle));
            }
        }
    }
}

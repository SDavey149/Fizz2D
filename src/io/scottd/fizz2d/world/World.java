package io.scottd.fizz2d.world;

import io.scottd.fizz2d.contact.Contact;
import io.scottd.fizz2d.force_generator.IParticleForceGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 03/04/2017.
 */
public class World {
    private WorldConfiguration worldConfiguration;

    private List<Particle> particles;
    private List<Particle> pending;

    public World(WorldConfiguration worldConfiguration) {
        this.worldConfiguration = worldConfiguration;
        particles = new ArrayList<>(50);
        pending = new ArrayList<>(10);
    }

    public void addGameObject(Particle particle) {
        pending.add(particle);
    }

    public void addGameObjects(List<Particle> particles) {
        pending.addAll(particles);
    }

    public void registerParticleForceGenerator(Particle particle, IParticleForceGenerator generator) {
        worldConfiguration.particleForceRegistry.registerParticle(particle, generator);
    }

    public void addGameObjects(Particle[] particles) {
        for (Particle particle : particles) {
            addGameObject(particle);
        }
    }

    public void update(double delta) {
        delta = delta/worldConfiguration.eulerUpdates;
        for (int i = 0; i < worldConfiguration.eulerUpdates; i++) {
            updateGameObjects(delta);
        }

        addPendingObjects();
    }

    private void addPendingObjects() {
        particles.addAll(pending);
        pending.clear();
    }

    private void updateGameObjects(double delta) {
        worldConfiguration.particleForceRegistry.updateRegisteredForces();
        for (Particle particle : particles) {
            particle.update(delta);
            worldBoundaryCheck(particle);
        }
        List<Contact> particleCollisions = worldConfiguration.contactDetectorRegistry.getContacts(particles);
        resolveContacts(particleCollisions);
    }

    private static void resolveContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            contact.resolve();
        }
    }

    //TODO: should be moved to io.scottd.fizz2d.force_generator contact detector
    //BUG: Balls can fall through the corners
    private void worldBoundaryCheck(Particle particle) {
        if (particle.getPosition().x + particle.getRadius() > worldConfiguration.worldSize.x
                || particle.getPosition().x - particle.getRadius() < 0) {
            particle.getVelocity().x*=-1;
        }
        else if (particle.getPosition().y + particle.getRadius() > worldConfiguration.worldSize.y
                || particle.getPosition().y - particle.getRadius() < 0) {
            particle.getVelocity().y*=-1;
        }
    }

}
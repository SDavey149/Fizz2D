package fizz2d.world;

import fizz2d.model.Particle;
import utilities.Vector2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 03/04/2017.
 */
public class World {
    private WorldConfiguration worldConfiguration;
    private static int NUM_EULER = 5;
    private Vector2 worldSize;

    private List<Particle> particles;

    public World(Vector2 worldSize) {
        particles = new ArrayList<>(50);
        this.worldSize = worldSize;
    }

    public void addGameObject(Particle particle) {
        particles.add(particle);
    }

    public void addGameObjects(List<Particle> particles) {
        this.particles.addAll(particles);
    }

    public void addGameObjects(Particle[] particles) {
        for (int i = 0; i < particles.length; i++) {
            addGameObject(particles[i]);
        }
    }

    public void update(double delta) {
        delta = delta/NUM_EULER;
        for (int i = 0; i < NUM_EULER; i++) {
            updateGameObjects(delta);
        }
    }

    private void updateGameObjects(double delta) {
        for (Particle particle : particles) {
            particle.update(delta);
            worldBoundaryCheck(particle);
        }
    }

    private void worldBoundaryCheck(Particle particle) {
        if (particle.getPosition().x + particle.getRadius() > worldSize.x
                || particle.getPosition().x - particle.getRadius() < 0) {
            particle.getVelocity().x*=-1;
        }
        else if (particle.getPosition().y + particle.getRadius() > worldSize.y
                || particle.getPosition().y - particle.getRadius() < 0) {
            particle.getVelocity().y*=-1;
        }
    }

}

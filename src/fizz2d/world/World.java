package fizz2d.world;

import fizz2d.model.Particle;
import utilities.Vector2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 03/04/2017.
 */
public class World {
    private WorldConfiguration worldConfiguration;
    private static int NUM_EULER = 5;
    private Vector2D worldSize;

    private List<Particle> particles;

    public World(Vector2D worldSize) {
        particles = new ArrayList<>(50);
        this.worldSize = worldSize;
    }

    public void addGameObject(Particle particle) {
        particles.add(particle);
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
        }
    }

}

package fizz2d.model;

import fizz2d.model.integrators.IUpdateIntegrator;
import utilities.Vector2D;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Particle {
    private double radius;
    private IUpdateIntegrator integrator;

    protected Vector2D position;
    protected Vector2D velocity;
    protected Vector2D forceAccumulator;
    protected double inverseMass;
    protected double dragDamping;

    public Particle(double mass) {
        this(new Vector2D(), mass);
    }

    public Particle(Vector2D position, double mass) {
        this.position = position;
        this.inverseMass = 1/mass;
        dragDamping = 1;
        this.velocity = new Vector2D();
        this.forceAccumulator = new Vector2D();
    }

    //region GETTERS
    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getAcceleration() {
        Vector2D acceleration = new Vector2D();
        acceleration.addScaled(forceAccumulator, inverseMass);
        return acceleration;
    }

    public Vector2D getForceAccumulated() {
        return forceAccumulator;
    }

    public double getInverseMass() {
        return inverseMass;
    }

    public double getDrag() {
        return dragDamping;
    }
    //endregion

    public void update(double delta) {
        integrator.update(delta, this);
    }


}

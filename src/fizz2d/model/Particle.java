package fizz2d.model;

import fizz2d.model.integrators.Eulers;
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
    protected Vector2D repeatableForce;
    protected double inverseMass;
    protected double dragDamping;

    public Particle(double radius, double mass) {
        this(radius, new Vector2D(), mass);
    }

    public Particle(double radius, Vector2D position, double mass) {
        this.position = position;
        this.inverseMass = 1/mass;
        dragDamping = 1;
        this.velocity = new Vector2D();
        this.forceAccumulator = new Vector2D();
        this.repeatableForce = new Vector2D();
        this.radius = radius;
        integrator = new Eulers();
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

    public double getRadius() { return radius; }
    //endregion

    public void update(double delta) {
        forceAccumulator.add(repeatableForce);
        integrator.update(delta, this);
    }

    public void addRepeatableForce(Vector2D force) {
        repeatableForce.add(force);
    }

    public void addForce(Vector2D force) {
        forceAccumulator.add(force);
    }


}

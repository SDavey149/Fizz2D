package io.scottd.fizz2d.model;

import io.scottd.fizz2d.world.integrators.Eulers;
import io.scottd.fizz2d.world.integrators.IUpdateIntegrator;
import io.scottd.fizz2d.model.Vector2;

/**
 * Created by scottdavey on 16/04/2017.
 */
public class Particle {
    private double radius;
    private IUpdateIntegrator integrator;

    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 forceAccumulator;
    protected Vector2 repeatableForce;
    protected double inverseMass;
    protected double dragDamping;

    public Particle(double radius, double mass) {
        this(radius, new Vector2(), mass);
    }

    public Particle(double radius, Vector2 position, double mass) {
        this.position = position;
        this.inverseMass = 1/mass;
        dragDamping = 1;
        this.velocity = new Vector2();
        this.forceAccumulator = new Vector2();
        this.repeatableForce = new Vector2();
        this.radius = radius;
        integrator = new Eulers();
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        Vector2 acceleration = new Vector2();
        acceleration.addScaled(forceAccumulator, inverseMass);
        return acceleration;
    }

    public Vector2 getForceAccumulated() {
        return forceAccumulator;
    }

    public double getInverseMass() {
        return inverseMass;
    }

    public double getDrag() {
        return dragDamping;
    }

    public double getRadius() { return radius; }

    public void setIntegrator(IUpdateIntegrator integrator) {
        this.integrator = integrator;
    }

    public void update(double delta) {
        forceAccumulator.add(repeatableForce);
        integrator.update(delta, this);
        forceAccumulator.set(0,0);
    }

    public void addForce(Vector2 force) {
        forceAccumulator.add(force);
    }

}

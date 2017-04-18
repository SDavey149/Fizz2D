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

    /*public boolean collidesWith(BasicParticle p2) {
        Vector2D vecFrom1to2 = Vector2D.minus(p2.getPos(), getPos());
        boolean movingTowardsEachOther = Vector2D.minus(p2.getVel(), getVel()).scalarProduct(vecFrom1to2)<0;
        return vecFrom1to2.mag()<getRadius()+p2.getRadius() && movingTowardsEachOther;
    }

    public static void implementElasticCollision(BasicParticle p1, BasicParticle p2, double e) {
        if (!p1.collidesWith(p2)) throw new IllegalArgumentException();
        Vector2D a = new Vector2D(p1.getPos());
        a.mult(-1);
        Vector2D normal = new Vector2D(p2.getPos());
        normal.add(a);
        normal.normalise();

        double Jb = (e+1)*(p1.getVel().scalarProduct(normal) - p2.getVel().scalarProduct(normal));
        Jb/= (1/p1.getMass() + 1/p2.getMass());

        Vector2D Vb = p2.getVel();
        Vector2D normal2 = new Vector2D(normal);
        normal2.mult(Jb / p2.getMass());
        Vb.add(normal2);
        p2.setVel(Vb);

        Vector2D Va = p1.getVel();
        Vector2D normal3 = new Vector2D(normal);
        normal3.mult(Jb/p1.getMass());
        normal3.mult(-1);
        Va.add(normal3);
        p1.setVel(Va);
    }*/

}

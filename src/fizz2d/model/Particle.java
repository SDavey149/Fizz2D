package fizz2d.model;

import fizz2d.world.integrators.Eulers;
import fizz2d.world.integrators.IUpdateIntegrator;
import utilities.Vector2;

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

    //region GETTERS & SETTERS
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
    //endregion

    public void update(double delta) {
        forceAccumulator.add(repeatableForce);
        integrator.update(delta, this);
    }

    public void addRepeatableForce(Vector2 force) {
        repeatableForce.add(force);
    }

    public void addForce(Vector2 force) {
        forceAccumulator.add(force);
    }

    /*public boolean collidesWith(BasicParticle p2) {
        Vector2 vecFrom1to2 = Vector2.minus(p2.getPos(), getPos());
        boolean movingTowardsEachOther = Vector2.minus(p2.getVel(), getVel()).scalarProduct(vecFrom1to2)<0;
        return vecFrom1to2.mag()<getRadius()+p2.getRadius() && movingTowardsEachOther;
    }

    public static void implementElasticCollision(BasicParticle p1, BasicParticle p2, double e) {
        if (!p1.collidesWith(p2)) throw new IllegalArgumentException();
        Vector2 a = new Vector2(p1.getPos());
        a.mult(-1);
        Vector2 normal = new Vector2(p2.getPos());
        normal.add(a);
        normal.normalise();

        double Jb = (e+1)*(p1.getVel().scalarProduct(normal) - p2.getVel().scalarProduct(normal));
        Jb/= (1/p1.getMass() + 1/p2.getMass());

        Vector2 Vb = p2.getVel();
        Vector2 normal2 = new Vector2(normal);
        normal2.mult(Jb / p2.getMass());
        Vb.add(normal2);
        p2.setVel(Vb);

        Vector2 Va = p1.getVel();
        Vector2 normal3 = new Vector2(normal);
        normal3.mult(Jb/p1.getMass());
        normal3.mult(-1);
        Va.add(normal3);
        p1.setVel(Va);
    }*/

}

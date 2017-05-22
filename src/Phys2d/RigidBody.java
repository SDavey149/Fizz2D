package Phys2d;


import utilities.Vector2;

/**
 * Created by scottdavey on 02/03/2016.
 */
public class RigidBody extends Body {

    private Vector2 forceToApply;
    private double mass;
    private boolean useGravity;
    private Vector2 frictionForce;

    public RigidBody(GameObject obj) {
        super(obj);
        this.mass = obj.mass;
        forceToApply = new Vector2();
        frictionForce = new Vector2();
        useGravity = true;
    }

    @Override
    public void update(double delta) {
        //a copy of forces to apply for improved euler, incase custom forces used
        Vector2 forceToApply2 = new Vector2(forceToApply);

        if (useGravity)
            forceToApply.add(object.getGravitationalForce());
        object.getAcceleration().set(0);
        if (forceToApply.mag() > 0) {
            object.getAcceleration().addScaled(forceToApply, 1/mass);
        }

        Vector2 vel2=new Vector2(object.getVelocity());
        Vector2 pos2=new Vector2(object.getPosition());

        //1 step ahead
        pos2.addScaled(object.getVelocity(), delta);
        vel2.addScaled(object.getAcceleration(), delta);
        Vector2 acc2=new Vector2();
        if (useGravity)
            forceToApply2.add(object.getGravitationalForceStepAhead(pos2, mass));
        if (forceToApply2.mag() > 0) {
            acc2.addScaled(forceToApply2, 1/mass);
        }
        vel2.add(object.getVelocity());
        vel2.mult(0.5);
        acc2.add(object.getAcceleration());
        acc2.mult(0.5);

        object.getPosition().addScaled(vel2, delta);
        object.getVelocity().addScaled(acc2, delta);

        forceToApply = new Vector2();
    }


    private Vector2 getParticleWeight() {
        return new Vector2(0, -World.gravity*mass);
    }

    public boolean collidesWith(GameObject o1, GameObject o2) {
        return false;
    }

    public void addForce(Vector2 force) {
        forceToApply.add(force);
    }

    public void useGravity(boolean gravity) {
        useGravity = gravity;
    }

    public Vector2 getFrictionForce() {
        return frictionForce;
    }
}

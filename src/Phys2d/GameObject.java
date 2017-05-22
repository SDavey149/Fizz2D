package Phys2d;

import utilities.Vector2;

/**
 * Created by scottdavey on 08/02/2016.
 */
public class  GameObject {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Vector2 rotation;
    private Shape shape;
    public double mass;
    private Body body;
    public World world;
    private CollideCallback collider;
    public String tag = "Unknown";

    public GameObject(Vector2 pos, CollideCallback collider) {
        position = pos;
        this.body = new Body(this);
        velocity = new Vector2();
        acceleration = new Vector2();
        rotation = new Vector2(1,0);
        this.collider = collider;
    }

    public void setWorld(World w) {
        world = w;
    }

    public void setShape(Shape sh) {
        shape = sh;
    }

    public Shape getShape() {
        return shape;
    }

    public Vector2 getRotation() {
        return rotation;
    }

    public void rotate(double theta) {
        rotation.rotate(theta);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void addRigidBody(Body body) {
        this.body = body;
    }

    public void update(double delta) {
        body.update(delta);
    }

    public boolean hasRigidBody() {
        return body instanceof RigidBody;
    }

    public Body getBody() {
        return body;
    }

    public Vector2 getGravitationalForce() {
        if (world != null) {
            return world.getGravitationalForce(this, this.getPosition(), this.mass);
        }
        return new Vector2(0,0);
    }

    public Vector2 getGravitationalForceStepAhead(Vector2 position, double mass) {
        if (world != null) {
            return world.getGravitationalForce(this, position, mass);
        }
        return new Vector2(0,0);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acc) {
        acceleration = acc;
    }

    public void collided(String tag) {
        collider.onCollide(tag);
    }


}

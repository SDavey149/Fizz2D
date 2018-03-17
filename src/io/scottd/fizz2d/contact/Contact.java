package io.scottd.fizz2d.contact;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.Particle;

/**
 * Created by Scott Davey on 22/05/2017.
 */
public abstract class Contact {
    public Particle[] particles;

    public Vector2 collisionAngle;

    public double penetration;

    public abstract void resolve();
}
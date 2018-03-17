package io.scottd.fizz2d.contact;

import io.scottd.fizz2d.world.Particle;

/**
 * Created by Scott Davey on 12/08/2017.
 */
public interface IContactDetector {
    Contact getContact(Particle p1, Particle p2);
}
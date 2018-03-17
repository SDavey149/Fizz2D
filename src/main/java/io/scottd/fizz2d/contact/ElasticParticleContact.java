package io.scottd.fizz2d.contact;

import io.scottd.fizz2d.Vector2;
import io.scottd.fizz2d.world.Particle;

public class ElasticParticleContact extends Contact {
    private double coefficientOfRestitution;

    public ElasticParticleContact(double coefficientOfRestitution) {
        this.coefficientOfRestitution = coefficientOfRestitution;
    }

    @Override
    public void resolve() {
        double totalInverseMass = particles[0].getInverseMass() + particles[1].getInverseMass();
        double jb = (coefficientOfRestitution +1)*(particles[0].getVelocity().scalarProduct(collisionAngle)
                - particles[1].getVelocity().scalarProduct(collisionAngle));
        jb /= totalInverseMass;

        resolveVelocity(jb, particles[1], collisionAngle);
        resolveVelocity(-jb, particles[0], collisionAngle);
    }

    private static void resolveVelocity(double jb, Particle particle, Vector2 collisionAngle) {
        Vector2 velocity = particle.getVelocity();
        Vector2 normal = getForceAlongNormal(jb, particle, collisionAngle);
        velocity.add(normal);
    }

    private static Vector2 getForceAlongNormal(double jb, Particle particle, Vector2 collisionAngle) {
        Vector2 normalB = new Vector2(collisionAngle);
        normalB.mult(jb * particle.getInverseMass());
        return normalB;
    }
}
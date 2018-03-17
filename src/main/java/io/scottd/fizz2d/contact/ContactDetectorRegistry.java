package io.scottd.fizz2d.contact;

import io.scottd.fizz2d.world.Particle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Davey on 22/05/2017.
 */
public class ContactDetectorRegistry {
    private static ContactDetectorRegistry contactDetectorRegistry;

    private List<IContactDetector> globalContactDetectors;
    private boolean orderContacts;

    public static ContactDetectorRegistry getInstance() {
        if (contactDetectorRegistry == null) {
            contactDetectorRegistry = new ContactDetectorRegistry();
        }
        return contactDetectorRegistry;
    }

    private ContactDetectorRegistry() {
        globalContactDetectors = new ArrayList<>();
        orderContacts = false;
    }

    public void registerContactDetector(IContactDetector contactDetector) {
        globalContactDetectors.add(contactDetector);
    }

    public List<Contact> getContacts(List<Particle> particles) {
        List<Contact> Contacts = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            Particle p1 = particles.get(i);
            for (int j = 0; j < i; j++) {
                Particle p2 = particles.get(j);
                applyContactDetectors(p1, p2, Contacts);
            }
        }
        OrderContacts(Contacts);
        return Contacts;
    }

    private void OrderContacts(List<Contact> contacts) {
        if (!orderContacts) {
            return;
        }

        //TODO: Order by penetration of the contact
    }

    private void applyContactDetectors(Particle p1, Particle p2, List<Contact> contacts) {
        for (IContactDetector detector : globalContactDetectors) {
            Contact contact = detector.getContact(p1, p2);
            if (contact == null) {
                continue;
            }

            contacts.add(contact);
        }
    }
}
package org.acme.service;

import org.acme.enity.Event;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class EventService {

    @Inject
    EntityManager entityManager;

    public List<Event> findAll() {
        //JPQL - Java Persistency Query Language
        return entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList();
    }

    @Transactional
    public void createEvent() {
        Event event = new Event("Our very first event!", new Date());
        //entityManager.getTransaction().begin();
        entityManager.persist(event);
        //entityManager.getTransaction().commit();
    }
}

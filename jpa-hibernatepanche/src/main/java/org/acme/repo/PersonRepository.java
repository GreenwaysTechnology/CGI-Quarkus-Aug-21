package org.acme.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    //your custom methods
    public Person findByName(String name) {
        return find("name", name).firstResult();
    }
}

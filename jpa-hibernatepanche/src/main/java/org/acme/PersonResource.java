package org.acme;

import org.acme.entity.Person;
import org.acme.repo.PersonRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/person")
public class PersonResource {

    @Inject
    PersonRepository repository;

    @GET
    public List<Person> findAll() {
        return repository.findAll().list();
    }

    @POST
    @Transactional
    public Response createAuthor(Person person) {
        repository.persist(person);
        return Response.created(URI.create("/person/" + person.getId())).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Optional<Person> optional = repository.findByIdOptional(id);
        return Response.ok(optional.orElse(new Person())).build();
    }

}

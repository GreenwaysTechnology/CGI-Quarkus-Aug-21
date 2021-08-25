package org.acme;

import org.acme.entity.Event;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    @GET
    public List<Event> list() {
        return Event.listAll();
    }

    @GET
    @Path("/{id}")
    public Event get(@PathParam("id") Long id) {
        Event event = Event.findById(id);
        if (event == null) {
            throw new WebApplicationException("Event with Id of " + id + " Not Found");
        }
        return event;
    }

    @GET
    @Path("/search/{name}")
    public Event search(@PathParam("name") String name) {
        Event event = Event.findByTitle(name);
        if (event == null) {
            throw new WebApplicationException("Event with Name of " + name + " Not Found");
        }
        return event;
    }

    @GET
    @Path("/count")
    public Response countEvents(@PathParam("name") String name) {
        return Response.ok(Event.count()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void removeEvent(@PathParam("id") Long id) {
        Event event = Event.findById(id);
        if (event == null) {
            throw new WebApplicationException("Event with Id of " + id + " Not Found");
        }
        event.delete();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateEvent(@PathParam("id") Long id, Event event) {
        Event foundEvent = Event.findById(id);
        if (foundEvent == null) {
            throw new WebApplicationException("Event with Id of " + id + " Not Found");
        }
        //update
        foundEvent.title = event.title;
        return Response.ok(foundEvent.id + foundEvent.title + "has been modified").build();
    }

    @POST
    @Transactional
    public Response createEvent(Event event) {
        event.eventDate = new Date();
        event.persist();
        return Response.created(URI.create("/events/" + event.id)).build();
    }

    //inner class
    @Provider
    public class ErrorMapper implements ExceptionMapper<Exception> {
        @Override
        public Response toResponse(Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }
}

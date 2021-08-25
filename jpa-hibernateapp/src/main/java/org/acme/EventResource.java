package org.acme;

import org.acme.service.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/events")
public class EventResource {

    @Inject
    EventService eventService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEvents() {
        return Response.ok(eventService.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent() {
        eventService.createEvent();
        return Response.status(201).entity("Event Created").build();
    }
}

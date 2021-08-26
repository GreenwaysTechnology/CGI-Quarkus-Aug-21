package org.acme;

import org.acme.entity.Author;
import org.acme.entity.Event;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @GET
    public List<Author> list() {
        return Author.listAll();
    }
    @POST
    @Transactional
    public Response createAuthor(Author author) {
        author.persist();
        return Response.created(URI.create("/events/" + author.id)).build();
    }
}

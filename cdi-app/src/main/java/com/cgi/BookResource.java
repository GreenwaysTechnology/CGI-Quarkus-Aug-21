package com.cgi;

import com.cgi.di.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response createBook(){
        return Response.ok(bookService.createBook()).build();
    }
}

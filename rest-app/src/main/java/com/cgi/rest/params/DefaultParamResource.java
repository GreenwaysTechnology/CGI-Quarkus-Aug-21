package com.cgi.rest.params;

import javax.ws.rs.*;

@Path("/book")
public class DefaultParamResource {

    @GET
    public String getQueryParam(@QueryParam("num") @DefaultValue("10") int num) {
        return "Query " + num;
    }

//    @GET
//    @Path("{id}")
//    public String getPathParam(@PathParam("id") @DefaultValue("100") int id) {
//        return id + "";
//    }
}

package com.cgi.rest.responses;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/responses")
public class ResponseResources {

    @GET
    @Path("/plain")
    public String sendPlainResponse() {
        return "Hello";
    }

    @GET
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User sendUserJSONResponse() {
        User user = new User(1, "admin", "admin");
        return user;
    }

    @GET
    @Path("/user/xml")
    @Produces(MediaType.APPLICATION_XML)
    public User sendUserXmlResponse() {
        User user = new User(1, "admin", "admin");
        return user;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendResponse() {
        //Type of data to be sent

        //OK -200 status - success
//        return Response
//                .ok("Hello Response")
//                .header("myheader", "myheadervalue")
//                .build();

//        return Response
//                .status(200)
//                .entity("Hello Response!!!")
//                .header("myheader", "myheadervalue")
//                .build();
//        return Response
//                .status(Response.Status.OK)
//                .entity("Hello Response!!!")
//                .header("myheader", "myheadervalue")
//                .build();
        return Response
                .status(Response.Status.OK)
                .entity("Hello Response!!!")
                .header("myheader", "myheadervalue")
                .build();
    }

    //Some Status code
    @POST
    public Response save() {
        return Response.status(201).entity("Saved").build();
    }


}

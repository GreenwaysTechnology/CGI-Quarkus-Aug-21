package com.cgi.rest.params;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users")
public class UserResource {

    /**
     *@Path("list/{userName:[a-zA-Z][a-zA-Z_0-9]*}")
     * valid urls
     * localhost:8080/users/list/Subramanian
     * localhost:8080/users/list/SUBRAMANIAN
     * localhost:8080/users/list/SUBRAM12333ANIAN
     *  @Path("list/{userName:[a-zA-Z]*}")
     *  valid urls:
     *  localhost:8080/users/list/SUBRAMANIAN
     */
    @GET
    //@Path("list/{userName:[a-zA-Z][a-zA-Z_0-9]*}")
    @Path("list/{userName:[a-zA-Z]*}")
    public String getUser(@PathParam("userName") String userName) {
        return "User Name Regex" + userName;
    }
}

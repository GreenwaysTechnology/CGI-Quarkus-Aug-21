package com.cgi.rest.params;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/register")
public class RegisterationFormResource {


    @POST
    @Path("/save")
        public String save(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName) {
        return "Form saved" + firstName + lastName;
    }

}

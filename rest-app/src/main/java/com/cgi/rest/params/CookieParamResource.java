package com.cgi.rest.params;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/login")
public class CookieParamResource {

    //send cook
    @GET
    @Path("/createcookie")
    public Response createCookie(@QueryParam("userName") String userName) {
//        NewCookie cookie = new NewCookie("userName", "Subramanian");
        NewCookie cookie = new NewCookie("userName", userName);

        //send cookie to the client
        return Response.ok("cookie sent").cookie(cookie).build();
    }

    @GET
    public String getCookie(@CookieParam("userName") String userName) {
        return "Cookie Name " + userName;
    }


}

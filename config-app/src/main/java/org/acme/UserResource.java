package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/myprop")
public class UserResource {

    @ConfigProperty(name = "myprop.value", defaultValue = "foo")
    String myprop;

    @GET
    public String user() {
        return myprop;
    }
}

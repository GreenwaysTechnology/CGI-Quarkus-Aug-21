package org.acme;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    //    @Inject @ConfigProperty(name="greeter.message")
    @ConfigProperty(name = "greeter.message", defaultValue = "Hello RestEasy!")
    String message;
    @ConfigProperty(name = "greeter.name", defaultValue = "foo")
    String name;
    @ConfigProperty(name = "greeter.date", defaultValue = "some value")
    String date;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return name + " " + message + " " + date;

    }

    //how to read property via configProvider
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greet")
    public String greet() {
        String userName = ConfigProvider.getConfig().getValue("myuser.name", String.class);
        return userName;

    }


}
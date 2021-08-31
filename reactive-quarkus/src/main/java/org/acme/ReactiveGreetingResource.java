package org.acme;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;

@Path("/hello")
public class ReactiveGreetingResource {

    @Inject
    GreeterService greeterService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy Reactive";
    }

    //react end point
    @GET
    @Path("/reactive")
    public Uni<String> hai() {
        System.out.println("Hai is running in : " + Thread.currentThread().getName());
        return Uni.createFrom().item("Hai,Reactive").onItem().transform(String::toLowerCase);
    }

    @GET
    @Path("/blocking")
    @Blocking //Vertx.executeBlocking(code)
    public String blockingMe() {
        System.out.println("Blocking Thread : " + Thread.currentThread().getName());
        return greeterService.sayHello();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{count}/{name}")
    public Multi<String> greetings(int count, String name) {
        System.out.println("greetings is running in : " + Thread.currentThread().getName());
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onItem().transform(n -> String.format("hello %s - %d", name, n))
                .select().first(count);

    }


}
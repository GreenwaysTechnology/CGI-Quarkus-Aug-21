package com.cgi;

import com.cgi.di.HelloService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

//    @Inject
//    HelloService helloService;

    HelloService helloService;
//
//    @Inject
//    public void setHelloService(HelloService helloService) {
//        this.helloService = helloService;
//    }


    //@Inject
    public HelloResource(HelloService helloService) {
        this.helloService = helloService;
    }

    @GET
    public Response sayHello() {
        return Response.ok(helloService.sayHello()).build();
    }
}

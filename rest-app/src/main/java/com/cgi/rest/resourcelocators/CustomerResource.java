package com.cgi.rest.resourcelocators;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class CustomerResource {

    @GET
    public String getCustomers() {
        return "customers resource";
    }

    @GET
    @Path("{id}")
    public String getCustomerById(@PathParam("id") String id) {
        return "customers resource by id" + id;
    }
}

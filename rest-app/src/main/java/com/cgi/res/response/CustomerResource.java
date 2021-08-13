package com.cgi.res.response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/customers")
public class CustomerResource {

//    @GET
//    public Customer getCustomer() {
//        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setName("Subramanian");
//        return customer;
//    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Subramanian");
        return Response.ok(customer).build();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public List<Customer> getCustomers() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Subramanian");
        List<Customer> customers = Arrays.asList(customer);
        return customers;
    }
}

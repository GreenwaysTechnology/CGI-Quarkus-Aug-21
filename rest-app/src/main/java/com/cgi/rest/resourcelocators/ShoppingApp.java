package com.cgi.rest.resourcelocators;

import javax.ws.rs.Path;

@Path("/cgi/api")
public class ShoppingApp {

    @Path("/customers")
    public CustomerResource getCustomer() {
        return new CustomerResource();
    }

    @Path("/payments")
    public PaymentResource getPayment() {
        return new PaymentResource();
    }
}

package com.cgi.rest.resourcelocators;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class PaymentResource {
    @GET
    public String getPayment() {
        return "Payment resource";
    }

    @GET
    @Path("{id}")
    public String getPayment(@PathParam("id") String id) {
        return "Payment resource by id" + id;
    }

    @Path("/creditcard")
    public CreditCardResource getCreditCard(){
          return new CreditCardResource();
    }

}

package com.cgi.rest.resourcelocators;

import javax.ws.rs.GET;

public class CreditCardResource {
    @GET
    public String getCreditCardDetails() {
        return "Credit Details";
    }
}

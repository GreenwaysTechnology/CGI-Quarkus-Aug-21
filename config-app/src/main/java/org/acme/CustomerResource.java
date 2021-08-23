package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerConfiguration custConfig;

    @GET
    public String customerInfo() {
        //  return custConfig.firstName;
//        return custConfig.name().orElse("default");
        String city = custConfig.address().city().orElse("cbe");
        return custConfig.name().orElse("defult") + " " + city;
    }
}

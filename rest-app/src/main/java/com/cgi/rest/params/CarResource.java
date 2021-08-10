package com.cgi.rest.params;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/car/{make}")
public class CarResource {

    //localhost:8080/car/mercedes/e55;color=black/2008
    @GET
    @Path("/{model}/{year}")
    public String getCarInfo(@MatrixParam("color") String color,
                             @PathParam("make") String make,
                             @PathParam("model") String model,
                             @PathParam("year") String year
    ) {

        return "Car " + color + make + model + year;
    }
}

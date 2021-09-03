package org.acme.rest.client;


import org.acme.models.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/v2")
@RegisterRestClient(configKey = "country-api")
public interface CountryService {
    //api to invoke third party
    @Path("/name/{name}")
    @GET
    Set<Country> getByName(@PathParam String name);
}

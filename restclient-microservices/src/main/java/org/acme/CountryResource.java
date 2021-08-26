package org.acme;

import org.acme.models.Country;
import org.acme.rest.client.CountryService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/country")
public class CountryResource {

    @Inject
    @RestClient
    CountryService countryService;

    @GET
    @Path("/name/{name}")
    public Set<Country> findByCountry(@PathParam("name") String name) {
        return countryService.getByName(name);
    }

}

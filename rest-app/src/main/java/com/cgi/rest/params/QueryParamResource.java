package com.cgi.rest.params;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/queryresource")
public class QueryParamResource {
    @GET
    public String getQueryParam(@QueryParam("num") int num, @QueryParam("start") int start, @QueryParam("size") int size) {
        return "Query Params" + num + " " + start + " " + size;
    }

    //localhost:8080/queryresource/ctx?num=10&start=1&size=100
    @GET
    @Path("ctx")
    public String getQueryParamUsingContext(@Context UriInfo uriInfo){
        String num = uriInfo.getQueryParameters().getFirst("num");
        String start =uriInfo.getQueryParameters().getFirst("start");
        String size = uriInfo.getQueryParameters().getFirst("size");
        return "Query Params using ctx " +  num + " " + start + " " + size;
    }
}

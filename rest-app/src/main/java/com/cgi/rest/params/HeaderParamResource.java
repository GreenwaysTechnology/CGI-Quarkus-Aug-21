package com.cgi.rest.params;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.Set;

@Path("/headers")
public class HeaderParamResource {

    @GET
    public String getHeaderInfo(@HeaderParam("Content-Type") String contentType ,@HeaderParam("Accept") String acceptType){
            return "Header" + contentType + " " + acceptType;
    }
    @GET
    @Path("/all")
    public String getAllHeaders(@Context HttpHeaders httpHeaders){
        //print only headers and not values - keySet returns only key portion
        httpHeaders.getRequestHeaders().keySet().forEach(header->{
            System.out.println(header);
        });
         return "all";
    }
}

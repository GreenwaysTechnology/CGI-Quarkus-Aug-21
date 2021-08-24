package org.acme;

import io.agroal.api.AgroalDataSource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Path("/hello")
public class GreetingResource {


    @Inject
    AgroalDataSource defaultDataSource;

    @GET
    public Response getConnectionStatus() {
        try {
            Connection conn = defaultDataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE TABLE1(id INT NOT NULL,  title VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO TABLE1 " + "VALUES (100, 'Subramanian')");
            ResultSet rs = stmt.executeQuery("select * from table1");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
            stmt.close();
            conn.close();
        } catch (Exception es) {
            System.out.println("Database error" + es.getMessage());
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}
package api;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("conn")
public class manager {
	DataBase db=new DataBase();
	@GET
	public void connessione() {
		try {
			db.conn();
			System.out.println("si");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") long id) {
		return null;
        
         //return Response.ok().build();
         
        
        //return Response.status(Response.Status.NOT_FOUND).build();
    }
}

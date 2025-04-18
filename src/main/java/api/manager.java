package api;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("conn")
public class manager {
	DataBase db = new DataBase();

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
	@Path("ID/{id}")
	public List<film> getDirector(@PathParam("id") int id) throws SQLException {
		db.conn();
		System.out.println("si");

		List<film> F = db.ricercaInt("ID", id);
		db.discon();

		return F;
	}

	@GET
	@Path("name/{id}")
	public List<film> getName(@PathParam("id") String id) throws SQLException {
		db.conn();
		System.out.println("si");

		List<film> F = db.ricercaString("name", id);
		db.discon();

		return F;
	}

	@GET
	@Path("director/{id}")
	public List<film> getDirector(@PathParam("id") String id) throws SQLException {
		db.conn();
		System.out.println("si");
		List<film> F = db.ricercaString("director", id);
		db.discon();

		return F;
	}
	
	@GET
	@Path("rating")
	public List<film> getRat() throws SQLException {
		db.conn();
		System.out.println("si");
		List<film> F = db.ordinaRating();
		db.discon();

		return F;
	}
	
	@POST
	@Path("nline")
	public Response add(film f) throws URISyntaxException, SQLException {
		int newID;
		
		db.conn();
		newID = db.insert(f);
		db.discon();
		return Response.created(new URI("api/conn/ID/" + newID)).build();
		//senza dice solo di aver creato la risorsa
	}
}

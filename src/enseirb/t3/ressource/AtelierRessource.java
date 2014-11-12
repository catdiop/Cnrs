package enseirb.t3.ressource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import enseirb.t3.entity.Atelier;

/**
<<<<<<< HEAD
 * @author catdiop, cchauvalon, ezogbo
=======
 * @author catdiop , ezogbo, cchauvalon
>>>>>>> 0e4a2d8fcaf947e7af3a08f26575feb9b1fa5d51
 *
 */
@Path("ateliers")
public class AtelierRessource {
	@POST
	public void create(@QueryParam("title") String title, @QueryParam("theme") String theme,
			@QueryParam("labo") String labo, @QueryParam("address") String address,
			@QueryParam("city") String city, @QueryParam("cp") String cpString) {
		
		Atelier a=new Atelier();
		a.setTitle(title);
		a.setTheme(theme);
		a.setLabo(labo);
		a.setAddress(address);
		a.setCp(Integer.parseInt(cpString));
		a.setCity(city);
		
		Datastore ds=ConnectToDatabase.connect();
		ds.save(a);
		System.out.println("POST");
		System.out.println("Labo :" + labo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Atelier> all() {
		Datastore ds=ConnectToDatabase.connect();
				
		Query<Atelier> q=ds.createQuery(Atelier.class);
		List<Atelier> ateliers=q.asList();
		System.out.println("GET");
		return ateliers;
	}
	
	
	@DELETE
	public void delete(@QueryParam("id") String id){
		Datastore ds=ConnectToDatabase.connect();
		Query<Atelier> atelier=ds.createQuery(Atelier.class).field("id").equal(id);
		ds.delete(atelier);
		System.out.println("DELETE");
	}
	
	@PUT
	public void modify(@QueryParam("id") String id, @QueryParam("title") String title, @QueryParam("theme") String theme,
			@QueryParam("labo") String labo, @QueryParam("address") String address,
			@QueryParam("city") String city, @QueryParam("cp") String cpString) {
		
		Datastore ds=ConnectToDatabase.connect();
		Query<Atelier> query=ds.createQuery(Atelier.class).field("id").equal(id);
		
		UpdateOperations<Atelier> ops = ds.createUpdateOperations(Atelier.class).set("title", title);
		ds.update(query, ops);
		System.out.println("modify");
	}
	
	
	
	
}


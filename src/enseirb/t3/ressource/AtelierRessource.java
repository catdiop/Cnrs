/**
 * 
 */
package enseirb.t3.ressource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import enseirb.t3.entity.Atelier;

/**
 * @author catdiop
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
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Atelier> all() {
		Datastore ds=ConnectToDatabase.connect();
				
		Query<Atelier> q=ds.createQuery(Atelier.class);
		List<Atelier> ateliers=q.asList();
		
		return ateliers;
	}
}

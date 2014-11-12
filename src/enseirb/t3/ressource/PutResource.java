package enseirb.t3.ressource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import enseirb.t3.entity.Atelier;

@Path("put")
public class PutResource {
	
	@POST
	public Response modify(@FormParam("city") String city, @FormParam("title") String title) {
		System.out.println("modify");
		
		Datastore ds=ConnectToDatabase.connect();
		Query<Atelier> query=ds.createQuery(Atelier.class).field("city").equal(city);
		
		UpdateOperations<Atelier> ops = ds.createUpdateOperations(Atelier.class).set("title", title);
		ds.update(query, ops);
		
		return Response
    			.status(200)
    			.entity("Modification enregistrée")
    			.build();

	}
	
}

package enseirb.t3.ressource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import enseirb.t3.entity.Atelier;

@Path("put")
public class PutResource {
	
	@POST
	public Response modify(@FormParam("Id") String identifiant, @FormParam("city") String city, @FormParam("title") String title,@QueryParam("theme") String theme,
			@QueryParam("labo") String labo, @QueryParam("address") String address, @QueryParam("cp") String cpString) {
		System.out.println("modify");
		
		Datastore ds=ConnectToDatabase.connect();
		ObjectId id= new ObjectId(identifiant);
		Query<Atelier> query=ds.createQuery(Atelier.class).field("id").equal(id);
		
		UpdateOperations<Atelier> ops = ds.createUpdateOperations(Atelier.class).set("title", title);
		ops.set("theme", theme);
		ops.set("city", city);
		ops.set("labo", labo);
		ops.set("address", address);
		ops.set("cp", cpString);
		ds.update(query, ops);
		
		return Response
    			.status(200)
    			.entity("Modification enregistrée")
    			.build();

	}
	
}

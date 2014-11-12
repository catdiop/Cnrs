package enseirb.t3.ressource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import enseirb.t3.entity.Atelier;

@Path("delete")
public class DeleteResource {

	@GET
	public Response delete(@QueryParam("city") String city){
		System.out.println("GET");
		Datastore ds=ConnectToDatabase.connect();
		Query<Atelier> atelier=ds.createQuery(Atelier.class).field("city").equal(city);
		ds.delete(atelier);
		return Response
    			.status(200)
    			.entity("Atelier supprimé")
    			.build();
	}
}

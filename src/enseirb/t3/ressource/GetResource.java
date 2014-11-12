package enseirb.t3.ressource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import enseirb.t3.entity.Atelier;


@Path("get")
public class GetResource {
	@GET
	public Response all() {
		Atelier firstAtelier = new Atelier();
		Datastore ds=ConnectToDatabase.connect();
				
		Query<Atelier> q=ds.createQuery(Atelier.class);
		List<Atelier> ateliers=q.asList();
		firstAtelier = ateliers.get(0);
		System.out.println("GET");
		return Response
    			.status(200)
    			.entity("id:" + firstAtelier.getId() + "\n" +
    					"Titre:" + firstAtelier.getTitle() + "\n" +
    					"Thème:" + firstAtelier.getTheme() + "\n" +
    					"Laboratoire:" + firstAtelier.getLabo() + "\n" +
    					"Adresse:" + firstAtelier.getAddress() + "\n" +
    					"Code postale:" + firstAtelier.getCp() + "\n" +
    					"Ville:" + firstAtelier.getCity() + "\n")
    			.build();
	}
	
	
}

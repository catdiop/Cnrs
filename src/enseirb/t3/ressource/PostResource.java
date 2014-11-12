package enseirb.t3.ressource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.code.morphia.Datastore;

import enseirb.t3.entity.Atelier;


@Path("post")
public class PostResource {

	@POST
	public Response create(@FormParam("title") String title, @FormParam("theme") String theme,
			@FormParam("labo") String labo, @FormParam("address") String address,
			@FormParam("city") String city, @FormParam("cp") String cpString) {
		
		
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
		return Response
    			.status(200)
    			.entity("Atelier enregistré")
    			.build();
		
	}
}

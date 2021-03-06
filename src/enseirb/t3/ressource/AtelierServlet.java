package enseirb.t3.ressource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import enseirb.t3.entity.Atelier;

@SuppressWarnings("serial")
public class AtelierServlet extends HttpServlet {

	private String idString;
	private Map<String,String> erreurs;
	private Map<String,String> themes;

	private void initThemes(){
		themes=new HashMap<String,String>();

		themes.put("Chimie", "Chimie");
		themes.put("Economie", "Economie");
		themes.put("Geographie", "Geographie");
		themes.put("Histoire", "Histoire");
		themes.put("Philosophie", "Philosophie");
		themes.put("Physique", "Physique");
		themes.put("Technologies", "Technologies");
		themes.put("Mathematiques", "Mathematiques");
		themes.put("Sciences numeriques", "Sciences numeriques");
		themes.put("Science de la terre", "Science de la terre");
		themes.put("Science de la vie", "Science de la vie");

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Atelier atelier=null;
		String voir=req.getParameter("voir");
		idString=req.getParameter("idString");
		Datastore ds=ConnectToDatabase.connect();
		initThemes();
		
		if(getValeur(req, "delete")!=null && getValeur(req, "delete").equals("delete")){
			Query<Atelier> qAtelier=ds.createQuery(Atelier.class).field("id").equal(new ObjectId(getValeur(req, "idString")));
			ds.delete(qAtelier);
			
			//retour à la liste
			Query<Atelier> q=ds.createQuery(Atelier.class);
			List<Atelier> ateliers=q.asList();
			req.setAttribute("ateliers", ateliers);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ateliers.jsp").forward(req, resp);
			return;
		}
		
		if(idString==null){
			atelier=new Atelier();	
		}
		else{
			
			atelier=ds.get(Atelier.class, new ObjectId(idString));

		}
		req.setAttribute("atelier", atelier);
		req.setAttribute("themes", this.themes);
		if(voir==null)
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajout.jsp").forward(req, resp);
		else
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ateliers1.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String title=null;
		String labo=null;
		String description=null;
		String address=null;
		String city=null;
		String cp=null;
		String dateString=null; 
		String theme=null;
		Date date=null;

		Datastore ds=ConnectToDatabase.connect();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");

		erreurs=validation(req);
		if(erreurs.isEmpty()){
			title=getValeur(req, "title");
			labo=getValeur(req, "labo");
			description=getValeur(req, "description");
			address=getValeur(req, "address");
			city=getValeur(req, "city");
			cp=getValeur(req, "cp");
			dateString=getValeur(req, "date"); 
			theme=getValeur(req, "theme");
			try{
				date=sdf.parse(dateString);
			}catch(ParseException e){}
		}

		if(!erreurs.isEmpty()) {
			Atelier atelier=new Atelier();
			req.setAttribute("atelier", atelier);
			req.setAttribute("themes", this.themes);
			req.setAttribute("erreurs", erreurs);	
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajout.jsp").forward(req, resp);
		}

		if(getValeur(req, "delete")==null || getValeur(req, "delete").isEmpty()){
			if(getValeur(req, "idString")==null){
				Atelier atelier=new Atelier();
				atelier.setTitle(title);
				atelier.setLabo(labo);
				atelier.setDescription(description);
				atelier.setAddress(address);
				atelier.setCity(city);
				atelier.setCp(Integer.parseInt(cp));
				atelier.setTheme(theme);
				atelier.setDate(date);

				ds.save(atelier);
				
				//retour à la liste
				Query<Atelier> q=ds.createQuery(Atelier.class);
				List<Atelier> ateliers=q.asList();
				req.setAttribute("ateliers", ateliers);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ateliers.jsp").forward(req, resp);
				return;
			}else{
				String str=getValeur(req, "idString");
				Query<Atelier> query=ds.createQuery(Atelier.class).field("id").equal(new ObjectId(str));

				UpdateOperations<Atelier> ops = ds.createUpdateOperations(Atelier.class)
						.set("title", getValeur(req, "title"))
						.set("theme", getValeur(req, "theme"))
						.set("labo", getValeur(req, "labo"))
						.set("description", getValeur(req, "description"))
						.set("address", getValeur(req, "address"))
						.set("city", getValeur(req, "city"))
						.set("cp", Integer.parseInt(cp))
						.set("date", date);

				ds.update(query, ops);
				
				//retour à la liste
				Query<Atelier> q=ds.createQuery(Atelier.class);
				List<Atelier> ateliers=q.asList();
				req.setAttribute("ateliers", ateliers);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ateliers.jsp").forward(req, resp);
				return;
			}
		}
	}


	public Map<String, String> validation(HttpServletRequest req) {
		Map<String,String> erreurs=new HashMap<String,String>();
		String title=getValeur(req, "title");
		String labo=getValeur(req, "labo");
		String description=getValeur(req, "description");
		String address=getValeur(req, "address");
		String city=getValeur(req, "city");
		String cp=getValeur(req, "cp");
		String dateString=getValeur(req, "date"); 
		String theme=getValeur(req, "theme");
		Date date=null;

		if(dateString==null || dateString.isEmpty()) {
			erreurs.put("erreurDate", "La date de l'atelier n'a pas ete speficiee.");
		}

		else {
			SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
			try{
				date=sdf.parse(dateString);
			}catch(ParseException e){
				erreurs.put("erreurDate", "La date de l'atelier n'est pas specifiee sous le bon format.");
				return erreurs;
			}
		}

		if(title==null || title.isEmpty()) {
			erreurs.put("erreurTitle", "Le titre de l'atelier n'a pas ete speficie.");
		}

		if(theme==null || theme.isEmpty()) {
			erreurs.put("erreurTheme", "Le theme de l'atelier n'a pas ete speficie.");
		}

		if(labo==null || labo.isEmpty()) {
			erreurs.put("erreurLabo", "Le laboratoire n'a pas ete speficie.");
		}

		if(description==null || description.isEmpty()) {
			erreurs.put("erreurDescription", "La description de l'atelier n'a pas ete speficiee.");
		}

		if(address==null || address.isEmpty()) {
			erreurs.put("erreurAddress", "L'adresse n'a pas ete speficiee.");
		}

		if(city==null || city.isEmpty()) {
			erreurs.put("erreurCity", "La ville n'a pas ete speficiee.");
		}

		if(cp==null || cp.isEmpty()) {
			erreurs.put("erreurCp", "Le code postal n'a pas ete speficie.");
		}

		return erreurs;
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	private static String getValeur(HttpServletRequest req, String nomChamp){
		String valeur=req.getParameter(nomChamp);
		if(valeur==null || valeur.trim().length() == 0){
			return null;
		}
		else{
			return valeur.trim();
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
}

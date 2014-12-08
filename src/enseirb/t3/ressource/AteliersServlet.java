package enseirb.t3.ressource;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import enseirb.t3.entity.Atelier;

/**
 * Servlet implementation class AteliersServlet
 */
@SuppressWarnings("serial")
public class AteliersServlet extends HttpServlet {
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Datastore ds=ConnectToDatabase.connect();
		Query<Atelier> q=ds.createQuery(Atelier.class);
		List<Atelier> ateliers=q.asList();
		req.setAttribute("ateliers", ateliers);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ateliers.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

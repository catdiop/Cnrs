/**
 * 
 */
package enseirb.t3.ressource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author catdiop
 *
 */

@ApplicationPath("/rest")
public class CnrsApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
	Set<Class<?>> classes = new HashSet<>();
	// ajouter la ressource a la liste
	classes.add(AtelierRessource.class);
	return classes;
	}
}

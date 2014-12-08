/**
 * 
 */
package enseirb.t3.type;

/**
 * @author catdiop
 *
 */
public enum AtelierType {
	MATHS("Mathématiques"),
	PHYSIQUE("Physiques"),
    CHIMIE("Chimie"),
    SCIENCEVIE("Science de la vie"),
    SCIENCETERRE("Science de la terre"),
    SCIENCENUMERIQUE("Science numérique"),
    TECHNOLOGIE("Tecnhologie"),
    HISTOIRE("Histoire"),
    PHILOSOPHIE("Phylosophie"),
    ECONOMIE("Economie"),
    ASTRONOMIE("Astronomie"),
    GEOGRAPHIE("Géographie");
	
	private String str;
	private AtelierType(String str) {
		this.str=str;
	}
	
	public String getString() {
		return this.str;
	}
}

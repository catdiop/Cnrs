/**
 * 
 */
package enseirb.t3.type;

/**
 * @author catdiop
 *
 */
public enum AtelierType {
	MATHS("Math�matiques"),
	PHYSIQUE("Physiques"),
    CHIMIE("Chimie"),
    SCIENCEVIE("Science de la vie"),
    SCIENCETERRE("Science de la terre"),
    SCIENCENUMERIQUE("Science num�rique"),
    TECHNOLOGIE("Tecnhologie"),
    HISTOIRE("Histoire"),
    PHILOSOPHIE("Phylosophie"),
    ECONOMIE("Economie"),
    ASTRONOMIE("Astronomie"),
    GEOGRAPHIE("G�ographie");
	
	private String str;
	private AtelierType(String str) {
		this.str=str;
	}
	
	public String getString() {
		return this.str;
	}
}

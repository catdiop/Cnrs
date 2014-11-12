/**
 * 
 */
package enseirb.t3.entity;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

/**
 * @author catdiop
 *
 */
public class Atelier {
	@Id ObjectId id;
	private String title;
	private String theme;
	private String labo;
	private String address;
	private int cp;
	private String city;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLabo() {
		return labo;
	}
	public void setLabo(String labo) {
		this.labo = labo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

package save;

import java.security.SecureRandom;

public class IdParam {

	String firstname, lastname, uniqueid,email;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid() {
		SecureRandom random = new SecureRandom();
	    int num = random.nextInt(100000);
	    String formatted = String.format("%05d", num); 
	    String unqid = getFirstname()+"-"+formatted;
		this.uniqueid = unqid;
	}
	public void setUniqueid(String uniqueid) {
		
		this.uniqueid = uniqueid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}

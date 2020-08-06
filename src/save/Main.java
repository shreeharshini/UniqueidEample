package save;

import java.security.SecureRandom;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fName = "fName";
	    String lName = "lName";
	    String email = "email@gmail.com";
	    String concat = fName+lName+email;
	    UUID result = UUID.nameUUIDFromBytes(concat.getBytes());
	    System.out.println(result);
	    System.out.print("value: "+result.variant());
	   
	    SecureRandom random = new SecureRandom();
	    int num = random.nextInt(100000);
	    String formatted = String.format("%05d", num); 
	    System.out.println(fName+"-"+formatted);

	}

}

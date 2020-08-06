package save;


import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveId")
public class SaveId extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String firstname=request.getParameter("firstname");  
	        String lastname=request.getParameter("lastname");  
	        String email = request.getParameter("email");
	        
	       
	        
	       
	        IdParam e=new IdParam();  
	        e.setFirstname(firstname);
	        e.setLastname(lastname);
	        e.setUniqueid();
	        e.setEmail(email);
	        
	        int status=CrudMethods.save(e); 
	        
	        String args[] = new String[4];
	        args[0] = firstname;
	        args[1] = lastname;
	        args[2] = email;
	        args[3] = e.getUniqueid();
	        
	        sendEmail.SendEmail.main(args);

	          
	         
	        if(status>0){  
	            out.print("<p>Record saved successfully! Please try to login</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  

}

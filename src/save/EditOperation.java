package save;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditOperation")  
public class EditOperation extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String uniqueid=request.getParameter("uniqueid");  
        String fname=request.getParameter("firstname");  
        String lname=request.getParameter("lastname");  
          
        IdParam e=new IdParam();  
        e.setFirstname(fname);
        e.setLastname(lname);
        e.setUniqueid(uniqueid);
       
        System.out.print(e.getUniqueid());
          
        int status=CrudMethods.update(e);  
        if(status>0){  
            response.sendRedirect("ViewUser");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
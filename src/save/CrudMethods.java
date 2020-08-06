package save;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class CrudMethods {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:harshini","test","test");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	

	public static int save(IdParam e){  
        int status=0;  
        

        try{  
            Connection con=CrudMethods.getConnection(); 
            
            String sql = "insert into example(fname,lname,uniqueid,email) values (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);  
            ps.setString(1,e.getFirstname());  
            ps.setString(2,e.getLastname()); 
            ps.setString(3, e.getUniqueid());
            ps.setString(4, e.getEmail());
                          
            status=ps.executeUpdate();  
            
            

              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
	public static int update(IdParam e){  
        int status=0;  
        try{  
            Connection con=CrudMethods.getConnection();  
            System.out.print(e.getUniqueid());
            PreparedStatement ps=con.prepareStatement(  
                         "update Example set lname=? where uniqueid=?"); 
            ps.setString(1,e.getLastname());  
            ps.setNString(2, e.getUniqueid());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
	public static IdParam getById(int id){  
		IdParam e=new IdParam();  
          
        try{  
            Connection con=CrudMethods.getConnection();  
            PreparedStatement ps=con.prepareStatement("select id from Example where uniqueid=?");  
            ps.setInt(1,id);  
           
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1)); 
                                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
            
        return e;  
    }  
}

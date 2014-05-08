package no.nith.isaand12.nattogdagprototype;

import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
  
import com.mysql.jdbc.Connection; 
  
public class DbHandler { 
      
    public static boolean getUserAutorization(String user, String password) { 
        String passwordHash = getPasswordHashFromDB(user); 
        return BCrypt.checkpw(password, passwordHash); 
    } 
      
    private static String getPasswordHashFromDB(String user) { 
        String passwordHash = ""; 
          
        try { 
        ConnectToDB cdb = new ConnectToDB("finole12", "finole12"); 
        Connection connection = (Connection) cdb.getConnection(); 
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT passord FROM bruker" + 
                " WHERE brukernavn = ?"); 
        preparedStatement.setString(1, user); 
        ResultSet resultSet = preparedStatement.executeQuery(); 
        resultSet.next(); 
        passwordHash = resultSet.getString("passord"); 
          
        //closing resources 
        cdb.close(); 
        preparedStatement.close(); 
        connection.close(); 
        resultSet.close(); 
          
        } catch(SQLException ex) { 
              
        } 
          
        return passwordHash; 
          
          
    } 
      
  
}

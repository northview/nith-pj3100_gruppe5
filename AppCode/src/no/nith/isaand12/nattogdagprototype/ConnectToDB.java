package no.nith.isaand12.nattogdagprototype;

import java.sql.*; 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource; 
  
public class ConnectToDB { 
    private String user; 
    private String password; 
    private Connection connection; 
      
  
    public ConnectToDB(String user, String password) { 
        this.user = user; 
        this.password = password; 
          
    } 
      
    public Connection getConnection() { 
        try { 
            MysqlDataSource ds = new MysqlDataSource(); 
            ds.setServerName("mysql.nith.no"); 
            ds.setDatabaseName("finole12"); 
            ds.setUser(user); 
            ds.setPassword(password); 
            connection = ds.getConnection(); 
              
        } catch(SQLException e) { 
            System.out.println("Connection error " + e); 
        } 
        return connection;           
                  
    } 
      
    public void close() { 
        try { 
            connection.close(); 
              
        } catch(SQLException e) { 
            System.out.println("Error closing connection " + e); 
        }        
    } 
}

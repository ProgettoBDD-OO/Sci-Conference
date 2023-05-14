package linker;

import java.sql.*;

public class DBConnection {

    Connection Connessione = null;
    private Statement statement;
    private static DBConnection instance;
    
    private DBConnection()  {
    	
        String user = "postgres";
        String password = "6540";
        String url = "jdbc:postgresql://localhost/Sci-ConferenceDB";
        
        try { Class.forName("org.postgresql.Driver"); } 
        
        catch (ClassNotFoundException e) { e.printStackTrace(); }

        try {
        	
            Connessione = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione riuscita.");
            
        } catch (SQLException e) { System.out.println("Connessione fallita." + e); }

        
        try { statement = Connessione.createStatement(); } 
        
        catch (SQLException e) { e.printStackTrace(); }
    } 

    
    public static DBConnection getConnection() { 
    	
    	if (instance == null) { instance = new DBConnection(); }

    	return instance; 
    }
    
    public Statement getStatement() { return statement; }
}
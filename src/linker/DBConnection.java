package linker;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class DBConnection {

    Connection Connessione = null;
    
    public void connettiDB()  {
    
        String user = "postgres";
        String password = "Sroberto20";
        String url = "jdbc:postgresql://localhost/Sci-ConferenceDB";
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("Classe non trovata.\n");
            e.printStackTrace();
        }

        try {
            Connessione = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione riuscita.\n");
            
        } catch (SQLException e) { System.out.println("Connessione fallita.\n" + e); }
    } 

    public Connection getConnection() { return Connessione; }
}
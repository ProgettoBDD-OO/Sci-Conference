package DAO;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class DBConnection {

    Connection Con = null;
    Scanner Scan = new Scanner(System.in);
    Calendar DataInizioConferenza;
    Calendar DataFineConferenza;
    
    
    public void Connetti()  {

        String user = "postgres";
        String password = "Sroberto20";
        String url = "jdbc:postgresql://localhost/Sci-ConferenceDB";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("Classe non trovata");
            e.printStackTrace();
        }

        try {
            Con = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione OK \n");
        } catch (SQLException e) {
            System.out.println("Connessione Fallita \n");
            System.out.println(e);
        }
 }

    public void insert(Connection Con) {
    	
    	DataInizioConferenza.set(2023, 04, 20);
    	DataFineConferenza.set(2023, 04, 24);
    	
        String insert = "INSERT INTO conferenza_scientifica VALUES (?,?,?,?,?,?);";

        try {
            PreparedStatement statement = Con.prepareStatement(insert);

            statement.setInt(1, 1001);
            statement.setString(2, "Sagittarius A*");
            statement.setDate(0, null, DataFineConferenza);
            statement.setDate(4, null, DataFineConferenza);
            statement.setString(5, "Come e perché fotografare buchi neri.");
            statement.setString(6, "Astronomia");
            
            statement.executeUpdate();

            System.out.print("Inserito!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return Con;
    }
}
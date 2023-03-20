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

    public Connection getConnection() {
        return Con;
    }
}
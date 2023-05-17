package DAO;

import DTO.Ente;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EnteDAO {

    private DBConnection DataBase;
    private Statement statement;

    public EnteDAO() {

    	DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }
   
    public Ente getEnte(String nome) {
    	
    	Ente ente = new Ente();
    	
    	String select = "SELECT * FROM enti WHERE nome = '" + nome + "';";
		
    	try {
    		
			ResultSet rs = statement.executeQuery(select);
			
			rs.next();
			ente.setNome(rs.getString(1));
			
		} catch (SQLException e) { e.printStackTrace(); }
    	
    	return ente;
    }
    

    public ArrayList<Ente> getEnti(String idConferenza) {

       ArrayList<Ente> enti = new ArrayList<Ente>();

        try {

            String query = "SELECT * FROM enti("+ idConferenza +");"; 
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                Ente ente = new Ente();
                ente.setNome(rs.getString(1));
                enti.add(ente);
            }

            return enti;

        } catch (Exception e) { return enti; }
    }
   
   
    public void insertEnte(String nome, int idConferenza) {
	   
    	String insert = "CALL insert_ente('"+ nome +"', "+ idConferenza +");";
   	
    	try { statement.executeUpdate(insert); }
    	
    	catch (SQLException e) { e.printStackTrace(); }
   	}
}
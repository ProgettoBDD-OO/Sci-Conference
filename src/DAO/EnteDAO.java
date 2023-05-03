package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.Ente;
import linker.DBConnection;

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
    

    public ArrayList<Ente> getEnti(int id_conferenza) {

       ArrayList<Ente> enti = new ArrayList<Ente>();

        try {

            String query = "SELECT * FROM enti("+ id_conferenza +");"; 
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {

                Ente ente = new Ente();
                ente.setNome(rs.getString(1));
                enti.add(ente);
            }

            return enti;

        } catch (Exception e) { return enti; }
    }
   
   
    public void insertEnte(String nome) {
	   
    	String insert = "INSERT INTO enti VALUES ('"+ nome +"');";
   	
    	try { 
    		
    		if (getEnte(nome) == null) { statement.executeUpdate(insert); }
			
    	} catch (SQLException e) { e.printStackTrace(); }
   	}
}
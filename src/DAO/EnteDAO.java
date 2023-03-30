package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.Ente;
import linker.DBConnection;

public class EnteDAO {

    private DBConnection DataBase;

    public EnteDAO() {

        DataBase = new DBConnection();
        DataBase.connettiDB();
   }
    

   public ArrayList<Ente> getEnte(String id_conferenza) {

       ArrayList<Ente> enti = new ArrayList<Ente>();

        try {

            String query = "SELECT nome FROM ente NATURAL JOIN organizzazione WHERE id_conferenza = '"+ id_conferenza +"';"; 
            PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

                Ente ente = new Ente();
                ente.setNome(rs.getString(1));
                enti.add(ente);
            }

            return enti;

        } catch (Exception e) { return enti; }
   }
   
   
   public void insertEnte(String nome) {
	   
	   String insert = "INSERT INTO enti VALUES ('DEFAULT', '"+ nome +"');";
   	
		try { 
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(insert); 
			statement.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace(); }
   }
}
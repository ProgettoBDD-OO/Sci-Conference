package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Conferenza;
import DTO.ConferenzaBacheca;
import linker.DBConnection;

public class ConferenzaBachecaDAO {
	
	private DBConnection DataBase;
	
	public ConferenzaBachecaDAO() {
		
		DataBase = new DBConnection();
		DataBase.connettiDB();
	}
	
	
	public void addConf(ConferenzaBacheca confBacheca) {
		
		String insert = "INSERT INTO proposte_bacheca VALUES (DEFAULT, '"+ confBacheca.getNome() +"', '"+ confBacheca.getDescrizione() +"', '"+ confBacheca.getTema() +"');";
		
		try { 
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(insert); 
			statement.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	
	public ArrayList<ConferenzaBacheca> getConferenzeBacheca() {
		
		ArrayList<ConferenzaBacheca> ConferenzeBacheca = new ArrayList<ConferenzaBacheca>();
		
		try {
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement("SELECT * FROM proposte_bacheca");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				ConferenzaBacheca confBacheca = new ConferenzaBacheca();
				confBacheca.setId(rs.getInt(1));
				confBacheca.setNome(rs.getString(2));
				confBacheca.setDescrizione(rs.getString(3));
				confBacheca.setTema(rs.getString(4));
				ConferenzeBacheca.add(confBacheca);
			}
			
			return ConferenzeBacheca;
			
		} catch (Exception e) { return ConferenzeBacheca; }
	}
	
	public ConferenzaBacheca getConferenzaBacheca(String nome) {
		
		ConferenzaBacheca confBacheca = new ConferenzaBacheca();
		
		try {
			
			String query = "SELECT * FROM proposte_bacheca WHERE nome = '"+ nome +"';"; 
			PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
				
			confBacheca.setId(rs.getInt(1));
			confBacheca.setNome(rs.getString(2));
			confBacheca.setDescrizione(rs.getString(3));
			confBacheca.setTema(rs.getString(4));
			
			return confBacheca;
			
		} catch (Exception e) { return confBacheca; }
	}
}
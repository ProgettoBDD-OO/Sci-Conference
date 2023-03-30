package DAO;

import DTO.ProposteBacheca;
import linker.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProposteBachecaDAO {
	
	private DBConnection DataBase;
	
	public ProposteBachecaDAO() {
		
		DataBase = new DBConnection();
		DataBase.connettiDB();
	}
	
	
	public void addConf(ProposteBacheca confBacheca) {
		
		String insert = "INSERT INTO proposte_bacheca VALUES (DEFAULT, '"+ confBacheca.getNome() +"', '"+ confBacheca.getDescrizione() +"', '"+ confBacheca.getTema() +"');";
		
		try { 
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(insert); 
			statement.executeUpdate();
		
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	
	public ArrayList<ProposteBacheca> getConferenzeBacheca() {
		
		ArrayList<ProposteBacheca> ConferenzeBacheca = new ArrayList<ProposteBacheca>();
		
		try {
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement("SELECT * FROM proposte_bacheca");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				ProposteBacheca confBacheca = new ProposteBacheca();
				confBacheca.setId(rs.getInt(1));
				confBacheca.setNome(rs.getString(2));
				confBacheca.setDescrizione(rs.getString(3));
				confBacheca.setTema(rs.getString(4));
				ConferenzeBacheca.add(confBacheca);
			}
			
			return ConferenzeBacheca;
			
		} catch (Exception e) { return ConferenzeBacheca; }
		
		finally { DataBase.closeConnection(); }
	}
	
	
	public ProposteBacheca getConferenzaBacheca(String nome) {
		
		ProposteBacheca confBacheca = new ProposteBacheca();
		
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
package DAO;

import DTO.Partecipante;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PartecipanteDAO {

    private DBConnection DataBase;
	private Statement statement;
	
	public PartecipanteDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	
	public ArrayList<Partecipante> getPartecipanti(String idIntervento){
		
		ArrayList<Partecipante> Partecipanti = new ArrayList<Partecipante>();
		
		try {
			
			String select = "SELECT * FROM partecipanti NATURAL JOIN partecipazione WHERE id_intervento = "+ idIntervento;
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Partecipante p = new Partecipante();
				p.setEmail(rs.getString(1));
                p.setTitolo(rs.getString(2));
                p.setNome(rs.getString(3));
                p.setCognome(rs.getString(4));
                p.setTitolo(rs.getString(5));
                
                Partecipanti.add(p);
			}
			
		} catch (SQLException e) { e.getMessage(); }
		
		return Partecipanti;
	}
	
	
	public Partecipante getPartecipante(String email) {
    	
		Partecipante partecipante = new Partecipante();
    	
    	try {
    		
    		String query = "SELECT * FROM partecipanti WHERE email = '"+ email +"';";
            ResultSet rs = statement.executeQuery(query);

            rs.next();

        	partecipante.setEmail(rs.getString(1));
            partecipante.setTitolo(rs.getString(2));
            partecipante.setNome(rs.getString(3));
            partecipante.setCognome(rs.getString(4));
            partecipante.setAfferenza(rs.getString(5));
    		
		} catch (SQLException e) { e.getMessage(); }

    	return partecipante;
    }
	
	
	public void insertPartecipante(Partecipante partecipante) {
		
        try {
        	
        	String insert = "CALL insert_partecipante('" + partecipante.getEmail() + "', '" + partecipante.getTitolo() + "', '" 
        	+ partecipante.getNome() + "', '" + partecipante.getCognome() + "', '" + partecipante.getAfferenza()+ "'," + partecipante.getIdIntervento() + ");";
        	    	
        	System.out.println(insert);
        	statement.executeUpdate(insert); 
        
        } catch (SQLException e) { e.getMessage(); }
	}
}
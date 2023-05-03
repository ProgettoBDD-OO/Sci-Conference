package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Organizzatore;
import DTO.Partecipante;
import linker.DBConnection;

public class PartecipanteDAO {

    private DBConnection DataBase;
	private Statement statement;
	
	public PartecipanteDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	
	public ArrayList<Partecipante> getPartecipanti(String id_intervento){
		
		ArrayList<Partecipante> Partecipanti = new ArrayList<Partecipante>();
		
		String select = "select * from partecipanti natural join partecipazione where id_intervento = "+ id_intervento;
		
		try {
			
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
			
		} catch (Exception e) { }
		
		return Partecipanti;
	}
	
	
	public Partecipante getPartecipante(String id) {
    	
		Partecipante partecipante = new Partecipante();
    	
    	try {
    		
    		String query = "SELECT * FROM partecipanti WHERE email = '"+ id +"';";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

            	partecipante.setEmail(rs.getString(1));
                partecipante.setTitolo(rs.getString(2));
                partecipante.setNome(rs.getString(3));
                partecipante.setCognome(rs.getString(4));
                partecipante.setAfferenza(rs.getString(5));
            }
    		
		} catch (Exception e) { e.getMessage(); }

    	return partecipante;
    }
}
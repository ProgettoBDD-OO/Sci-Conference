package DAO;

import DTO.Intervento;
import linker.DBConnection;
import myTools.myTemplates;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InterventoDAO {
	
	private DBConnection DataBase;
	private Statement statement;
	
	public InterventoDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	
	public ArrayList<Intervento> getInterventi(String idSessione) {
		
		ArrayList<Intervento> Interventi = new ArrayList<Intervento>();
		
		try {
			
			String select = "SELECT * FROM interventi WHERE id_sessione = " + idSessione +";";
			ResultSet rs = statement.executeQuery(select);
			
			while (rs.next()) {
				
				Intervento i = new Intervento();
				i.setIdIntervento(rs.getString(1));
				i.setOraInizio(rs.getTime(2));
				i.setOraFine(rs.getTime(3));
				i.setIdSessione(rs.getString(4));
				i.setDescrizione(rs.getString(5));
                
                Interventi.add(i);
			}
			
		} catch (SQLException e) { e.getMessage(); }
		
		return Interventi;
	}
	
	
	public void insertIntervento(Intervento intervento) {
		
		myTemplates t = new myTemplates();
		
		try {
			
			String insert = "INSERT INTO interventi VALUES ("+ intervento.getIdIntervento() +", '"
			+ t.toTimeFormat(intervento.getOraInizio().getTime()) + "', '" + t.toTimeFormat(intervento.getOraFine().getTime()) + "', "
			+ intervento.getIdSessione() + ", '"+ intervento.getDescrizione() +"');";
	        statement.executeUpdate(insert); 
		}
		
		catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void updateIntervento(Intervento intervento) {
		
		myTemplates t = new myTemplates();
		
		try {
			
			String update = "UPDATE interventi SET "
					  	  + "ora_inizio = '"+ t.toTimeFormat(intervento.getOraInizio().getTime()) +"', "
					      + "ora_fine = '"+ t.toTimeFormat(intervento.getOraFine().getTime()) + "', "
					      + "descrizione = '" + intervento.getDescrizione()  + "' "
					      + "WHERE id_intervento = " + intervento.getIdIntervento() + ";";
			
			statement.executeUpdate(update); 
			
			System.out.println(update);
			
		} catch (SQLException e) { e.getMessage(); }
	}
}
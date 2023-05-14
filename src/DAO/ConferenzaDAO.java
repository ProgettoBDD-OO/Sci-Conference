package DAO;

import DTO.Conferenza;
import linker.DBConnection;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConferenzaDAO {
	
	private DBConnection DataBase;
	private Statement statement;
	
	
	public ConferenzaDAO() {
		
		DataBase = DBConnection.getConnection();
		statement = DataBase.getStatement();
	}
	
	public ArrayList<Conferenza> getConferenze() {
		
		ArrayList<Conferenza> Conferenze = new ArrayList<Conferenza>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM conferenze_scientifiche ORDER BY data_inizio");
			
			while (rs.next()) {
				
				Conferenza conf = new Conferenza();
				conf.setId(rs.getString(1));
				conf.setNome(rs.getString(2));
				conf.setDataInizio(rs.getDate(3));
				conf.setDataFine(rs.getDate(4));
				conf.setDescrizione(rs.getString(5));
				conf.setTema(rs.getString(6));
				Conferenze.add(conf);
			}
			
			return Conferenze;
			
		} catch (Exception e) { return Conferenze; }
	}
	
	
	public Conferenza getConferenza(String id) {
		
		Conferenza conf = new Conferenza();
		
		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM conferenze_scientifiche WHERE id_conferenza = '"+ id +"';");
			
			rs.next();
				
			conf.setId(rs.getString(1));
			conf.setNome(rs.getString(2));
			conf.setDataInizio(rs.getDate(3));
			conf.setDataFine(rs.getDate(4));
			conf.setDescrizione(rs.getString(5));
			conf.setTema(rs.getString(6));
			
			return conf;
			
		} catch (Exception e) { return conf; }
	}
	
	public Conferenza getConferenzaByDate(String dataConf) {
		
		Conferenza conf = new Conferenza();
		
		try {
			
			String query = "SELECT * FROM conferenze_scientifiche WHERE data_inizio = '"+ dataConf +"';";
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				
				conf.setId(rs.getString(1));
				
				conf.setNome(rs.getString(2));
					
				conf.setDataInizio(rs.getDate(3));
				conf.setDataFine(rs.getDate(4));
					
				conf.setDescrizione(rs.getString(5));
				conf.setTema(rs.getString(6));
			}
			
			return conf;
			
		} catch (Exception e) { return conf; }
	}
	
	
	public ArrayList<Conferenza> getConferenzeUtente(String email) {

        ArrayList<Conferenza> Conferenze = new ArrayList<Conferenza>();
        
        String select = "SELECT * FROM conferenze_utente('"+ email +"');";

         try {

            ResultSet rs = statement.executeQuery(select);

            while (rs.next()) {

                Conferenza conf = new Conferenza();
                conf.setId(rs.getString(1));
                conf.setNome(rs.getString(2));
                conf.setTema(rs.getString(3));
                Conferenze.add(conf);
            }

            return Conferenze;

        } catch (Exception e) { return Conferenze; }
    }
		
    public ArrayList<Conferenza> getConferenzeRicerca(String nome, String temi, String collocazioni){
	    
    	ArrayList<Conferenza> Conferenze = new ArrayList<Conferenza>();
    	
    	String select = "SELECT * FROM filtered_research('" + nome + "', "+ temi + ", " + collocazioni + ");";
    	System.out.println(select);
    	
        try {
        	
           ResultSet rs = statement.executeQuery(select);
           
           while (rs.next()) {

               Conferenza conf = new Conferenza();
               conf.setId(rs.getString(1));
               conf.setNome(rs.getString(2));
               conf.setTema(rs.getString(3));
               Conferenze.add(conf);
           }
           
           return Conferenze;

       } catch (SQLException e) { return Conferenze; }
	}
	
    public boolean checkIscrizione(String email, String id_conferenza) {
		
		String query = "SELECT * FROM iscrizioni('"+ email +"', "+ id_conferenza +");"; 
		boolean ConferenzaPresente = false;
		
		try {
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) { ConferenzaPresente = true; }
			
		} catch (SQLException e) { e.printStackTrace(); }
		
		return ConferenzaPresente;
	}
    
    public int getLastId() {
    	
    	String query = "SELECT id_conferenza from conferenze_scientifiche order by id_conferenza desc limit 1;";
    	int NextId = 0;
    	
    	try {
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) { NextId = rs.getInt(1); }
			
		} catch (SQLException e) { e.printStackTrace(); }
		
    	return NextId;
    }
    
    public void insertConferenza(String query) {

        String insert = "INSERT INTO conferenze_scientifiche VALUES (DEFAULT, '" + query + "');";

        System.out.println(insert);
        
        try { statement.executeUpdate(insert); } 
        
        catch (SQLException e) { e.printStackTrace(); }
    }	
}

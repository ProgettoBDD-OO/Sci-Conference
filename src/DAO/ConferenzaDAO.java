package DAO;

import DTO.Conferenza;
import linker.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class ConferenzaDAO {
	
	private DBConnection DataBase;
	
	public ConferenzaDAO() {
		
		DataBase = new DBConnection();
		DataBase.connettiDB();
	}
	
	public ArrayList<Conferenza> getConferenze() {
		
		ArrayList<Conferenza> Conferenze = new ArrayList<Conferenza>();
		
		try {
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement("SELECT * FROM conferenze_scientifiche");
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				Conferenza conf = new Conferenza();
				conf.setId(rs.getInt(1));
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
	
	
	public Conferenza getConferenza(String nome) {
		
		Conferenza conf = new Conferenza();
		
		try {
			
			String query = "SELECT * FROM conferenze_scientifiche WHERE nome = '"+ nome +"';"; 
			PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			rs.next();
				
			conf.setId(rs.getInt(1));
			conf.setNome(rs.getString(2));
			conf.setDataInizio(rs.getDate(3));
			conf.setDataFine(rs.getDate(4));
			conf.setDescrizione(rs.getString(5));
			conf.setTema(rs.getString(6));
			
			return conf;
			
		} catch (Exception e) { return conf; }
	}
	
	public Conferenza getNomeDiviso(String dataConf) {
		
		Conferenza conf = new Conferenza();
		
		try {
			
			String query = "SELECT primasecondospazio(nome), doposecondospazio(nome), data_inizio, data_fine, descrizione, tema FROM conferenze_scientifiche WHERE data_inizio = '"+dataConf+"';";
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				conf.setNome(rs.getString(1) + rs.getString(2));
				
				conf.setNomePrimaParte(rs.getString(1));
				conf.setNomeSecondaParte(rs.getString(2));
					
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
        String select = "SELECT nome, tema FROM conferenze_scientifiche NATURAL JOIN iscrizioni_conferenze WHERE email = '"+ email +"';";

         try {

            PreparedStatement statement = DataBase.getConnection().prepareStatement(select);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Conferenza conf = new Conferenza();
                conf.setNome(rs.getString(1));
                conf.setTema(rs.getString(2));
                Conferenze.add(conf);
            }

            return Conferenze;

        } catch (Exception e) {
            e.getMessage();
            return Conferenze;
        }
    }
	
	public ArrayList<Conferenza> getConferenzeRicerca(String query) {
		
		ArrayList<Conferenza> Conferenze = new ArrayList<Conferenza>();

        try {

           PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
           ResultSet rs = statement.executeQuery();
           
           while (rs.next()) {

               Conferenza conf = new Conferenza();
               conf.setNome(rs.getString(1));
               conf.setTema(rs.getString(2));
               Conferenze.add(conf);
           }

           return Conferenze;

       } catch (SQLException e) { return Conferenze; }
	}
	
	public boolean checkIscrizione(String email, int id_conferenza) {
		
		String query = "SELECT * FROM iscrizioni_conferenze WHERE email = '"+ email +"' AND id_conferenza = '"+ id_conferenza +"';"; 
		boolean ConferenzaPresente = false;
		
		try {
			
			PreparedStatement statement = DataBase.getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) { ConferenzaPresente = true; }
			
		} catch (SQLException e) { e.printStackTrace(); }
		
		return ConferenzaPresente;
	}
}
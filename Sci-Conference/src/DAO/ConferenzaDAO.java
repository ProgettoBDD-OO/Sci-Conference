package DAO;

import DTO.Conferenza;
import linker.DBConnection;
import myTools.myTemplates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConferenzaDAO {

	private DBConnection DataBase;
	private Statement statement;

	public ConferenzaDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}


	public ArrayList<Conferenza> getConferenze() {

		ArrayList<Conferenza> Conferenze = new ArrayList<>();

		try {

			String select = "SELECT * FROM conferenza ORDER BY data_inizio";
			ResultSet rs = statement.executeQuery(select);

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

		} catch (SQLException e) { e.getMessage(); }

		return Conferenze;
	}

	public Conferenza getConferenza(String idConferenza) {

		Conferenza conf = new Conferenza();

		try {

			String select = "SELECT * FROM conferenze(" + idConferenza + ");";
			ResultSet rs = statement.executeQuery(select);

			rs.next();
			
			conf.setId(idConferenza);
			conf.setNome(rs.getString(1));
			conf.setDataInizio(rs.getDate(2));
			conf.setDataFine(rs.getDate(3));
			conf.setDescrizionePrimaParte(rs.getString(4));
			conf.setDescrizioneSecondaParte(rs.getString(5));
			conf.setDescrizione(conf.getDescrizionePrimaParte() + conf.getDescrizioneSecondaParte());
			conf.setTema(rs.getString(6));
			
		} catch (SQLException e) { e.getMessage(); }

		return conf;
	}

	public Conferenza getConferenzaByDate(String dataConf) {

		Conferenza conf = new Conferenza();

		try {

			String select = "SELECT * FROM conferenza WHERE data_inizio = '"+ dataConf +"';";
			ResultSet rs = statement.executeQuery(select);

			rs.next();

			conf.setId(rs.getString(1));
			conf.setNome(rs.getString(2));
			conf.setDataInizio(rs.getDate(3));
			conf.setDataFine(rs.getDate(4));
			conf.setDescrizione(rs.getString(5));
			conf.setTema(rs.getString(6));

		} catch (SQLException e) {  e.getMessage(); }

		return conf;
	}

	public ArrayList<Conferenza> getConferenzeUtente(String email) {

        ArrayList<Conferenza> Conferenze = new ArrayList<>();

         try {

        	 String select = "SELECT * FROM conferenze_utente('"+ email +"');";
        	 ResultSet rs = statement.executeQuery(select);

        	 while (rs.next()) {

                Conferenza conf = new Conferenza();
                conf.setId(rs.getString(1));
                conf.setNome(rs.getString(2));
                conf.setTema(rs.getString(3));
                Conferenze.add(conf);
        	 }

         } catch (SQLException e) { e.getMessage(); }

         return Conferenze;
    }

    public ArrayList<Conferenza> getConferenzeRicerca(String nome, String temi, String collocazioni, String date) {

    	ArrayList<Conferenza> Conferenze = new ArrayList<>();

        try {

        	String select = "SELECT * FROM filtered_research('" + nome + "', "+ temi + ", " + collocazioni + ", "+ date +");";
        	ResultSet rs = statement.executeQuery(select);

			while (rs.next()) {

				Conferenza conf = new Conferenza();
			    conf.setId(rs.getString(1));
			    conf.setNome(rs.getString(2));
			    conf.setTema(rs.getString(3));
			    Conferenze.add(conf);

			}

        } catch (SQLException e) { e.getMessage(); }

        return Conferenze;
	}


    public int getLastId() {

    	int NextId = 0;

    	try {

    		String select = "SELECT id_conferenza from conferenza order by id_conferenza desc limit 1;";
			ResultSet rs = statement.executeQuery(select);

			while (rs.next()) { NextId = rs.getInt(1); }

		} catch (SQLException e) { e.getMessage(); }

    	return NextId;
    }


    public void insertConferenza(Conferenza conf) {

    	myTemplates t = new myTemplates();

        String insert = "INSERT INTO conferenza VALUES (DEFAULT, '" + conf.getNome() + "', '"
        			  												+ t.sqlFormat(conf.getDataInizio()) + "', '"
        			  												+ t.sqlFormat(conf.getDataFine()) + "', '" 
        			  												+ conf.getDescrizione() + "', '"
        			  												+ conf.getTema() + "', " 
        			  												+ conf.getIdCollocazione() + ");";
        try { statement.executeUpdate(insert); }

        catch (SQLException e) { e.getMessage(); }
    }

    public void updateConferenza(Conferenza conf) {

    	myTemplates t = new myTemplates();

    	try {

    		String update = "UPDATE conferenza SET "
    					  + "nome = '" + conf.getNome() + "', "
    					  + "data_inizio = '" + t.sqlFormat(conf.getDataInizio()) + "', "
    					  + "data_fine = '" + t.sqlFormat(conf.getDataFine()) + "', "
    					  + "descrizione = '" + conf.getDescrizione() + "', "
    					  + "tema = '" + conf.getTema() + "', "
    					  + "id_collocazione = " + conf.getIdCollocazione() + " "
    					  + "WHERE id_conferenza = " + conf.getId() + ";";
    		
    		statement.executeUpdate(update);

    	} catch (SQLException e) { e.getMessage(); }
    }

    public void deleteConferenza(String idConferenza) {

    	String delete = "DELETE FROM conferenza WHERE id_conferenza = " + idConferenza;

    	try { statement.executeUpdate(delete); }

        catch (SQLException e) { e.getMessage(); }
    }
}
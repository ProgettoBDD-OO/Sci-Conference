package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Sessione;
import linker.DBConnection;
import myTools.myTemplates;


public class SessioneDAO {

	private DBConnection DataBase;
	private Statement statement;

	public SessioneDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}


	public ArrayList<Sessione> getSessioni(String idConferenza) {

		ArrayList<Sessione> Sessioni = new ArrayList<>();

		try {

			String select = "SELECT * FROM sessione WHERE id_conferenza = '" + idConferenza + "' ORDER BY id_sessione;";
			ResultSet rs = statement.executeQuery(select);

			while (rs.next()) {

				Sessione s = new Sessione();

				s.setId(rs.getString(1));
				s.setDataInizio(rs.getDate(2));
				s.setDataFine(rs.getDate(3));
				s.setCoordinatore(rs.getString(4));
				s.setKeynoteSpeaker(rs.getString(5));
				s.setLocazione(rs.getString(6));
				s.setIdConferenza(rs.getInt(7));

				Sessioni.add(s);
			}

		} catch (SQLException e) { e.getMessage(); }

		return Sessioni;
	}

	public Sessione getSessione(String idSessione) {

		Sessione s = new Sessione();

		try {

			String select = "SELECT * FROM sessione WHERE id_sessione = '" + idSessione + "'";
			ResultSet rs = statement.executeQuery(select);

			rs.next();

			s.setId(rs.getString(1));
			s.setDataInizio(rs.getDate(2));
			s.setDataFine(rs.getDate(3));
			s.setCoordinatore(rs.getString(4));
			s.setKeynoteSpeaker(rs.getString(5));
			s.setLocazione(rs.getString(6));
			s.setIdConferenza(rs.getInt(7));


		} catch (SQLException e) { e.getMessage(); }

		return s;
	}


	public void insertSessione(Sessione sessione, int idConferenza) {

		myTemplates t = new myTemplates();

		String insert = "INSERT INTO sessione VALUES (" + sessione.getId() + ", '"
														+ t.sqlFormat(sessione.getDataInizio()) + "', '"
														+ t.sqlFormat(sessione.getDataFine()) + "', '"
														+ sessione.getCoordinatore() + "', '"
														+ sessione.getKeynoteSpeaker() + "', '"
														+ sessione.getLocazione() +"', "
														+ idConferenza + ");";
		try { statement.executeUpdate(insert); }

		catch (SQLException e) { e.getMessage(); }
	}


	public void updateSessione(String update) {
		
		try { statement.executeUpdate(update); }

		catch (SQLException e) { e.getMessage(); }
	}
}
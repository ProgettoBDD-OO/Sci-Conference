package DAO;

import DTO.KeynoteSpeaker;
import DTO.Ente;
import linker.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class KeynoteSpeakerDAO {

	private DBConnection DataBase;
	private Statement statement;

	public KeynoteSpeakerDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}


	public ArrayList<Ente> getAfferenze(int month, int year) {

		ArrayList<Ente> enti = new ArrayList<>();

		try {

			String select;
			if (month == -1) { select = "SELECT * FROM afferenze_by_year("+ year +");"; }

			else { select = "SELECT * FROM afferenze_by_month("+ month +", "+ year +");"; }

			ResultSet rs = statement.executeQuery(select);
			Ente.azzeraTotale();

			while (rs.next()) {

				Ente e = new Ente();
				e.setNome(rs.getString(1));
				e.setOccorrenze(rs.getInt(2));

				enti.add(e);
			}

		} catch (SQLException e) { e.getMessage(); }

		return enti;
	}


	public void insertKeynoteSpeaker(KeynoteSpeaker keynoteSpeaker) {

		String insert = "CALL insert_keynote('" + keynoteSpeaker.getEmail() + "', '" 
												+ keynoteSpeaker.getTitolo() + "', '"
												+ keynoteSpeaker.getNome() + "', '"
												+ keynoteSpeaker.getCognome() +"', '" 
												+ keynoteSpeaker.getAfferenza() + "'); ";
        try {  statement.executeUpdate(insert); }

        catch (SQLException e) { e.getMessage(); }
	}
}
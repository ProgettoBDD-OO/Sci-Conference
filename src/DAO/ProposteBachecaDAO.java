package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ProposteBacheca;
import linker.DBConnection;


public class ProposteBachecaDAO {

	private DBConnection DataBase;
	private Statement statement;

	public ProposteBachecaDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}


	public void addConf(ProposteBacheca confBacheca) {

		String insert = "INSERT INTO proposta_bacheca VALUES (DEFAULT, '"+ confBacheca.getNome() +"', '"+ confBacheca.getDescrizione() +"', '"+ confBacheca.getTema() +"');";

		try { statement.executeUpdate(insert);

		} catch (SQLException e) { e.printStackTrace(); }
	}


	public ArrayList<ProposteBacheca> getConferenzeBacheca() {

		ArrayList<ProposteBacheca> ConferenzeBacheca = new ArrayList<>();

		try {

			ResultSet rs = statement.executeQuery("SELECT * FROM proposta_bacheca ORDER BY random() LIMIT 6");

			while (rs.next()) {

				ProposteBacheca confBacheca = new ProposteBacheca();
				confBacheca.setId(rs.getString(1));
				confBacheca.setNome(rs.getString(2));
				confBacheca.setDescrizione(rs.getString(3));
				confBacheca.setTema(rs.getString(4));
				ConferenzeBacheca.add(confBacheca);
			}

			return ConferenzeBacheca;

		} catch (Exception e) { return ConferenzeBacheca; }
	}


	public ProposteBacheca getConferenzaBacheca(String nome) {

		ProposteBacheca confBacheca = new ProposteBacheca();

		try {

			String query = "SELECT * FROM proposta_bacheca WHERE nome = '"+ nome +"';";
			ResultSet rs = statement.executeQuery(query);

			rs.next();

			confBacheca.setId(rs.getString(1));
			confBacheca.setNome(rs.getString(2));
			confBacheca.setDescrizione(rs.getString(3));
			confBacheca.setTema(rs.getString(4));

			return confBacheca;

		} catch (Exception e) { return confBacheca; }
	}
}
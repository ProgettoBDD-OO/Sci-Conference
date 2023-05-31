package DAO;

import DTO.Intervento;
import linker.DBConnection;
import myTools.myTemplates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.formdev.flatlaf.ui.FlatPopupFactory;


public class InterventoDAO {

	private DBConnection DataBase;
	private Statement statement;

	public InterventoDAO() {

		DataBase = DBConnection.getInstance();
		statement = DataBase.getStatement();
	}


	public ArrayList<Intervento> getInterventi(String idSessione) {

		ArrayList<Intervento> Interventi = new ArrayList<>();

		try {

			String select = "SELECT * FROM intervento WHERE id_sessione = " + idSessione +";";
			ResultSet rs = statement.executeQuery(select);

			while (rs.next()) {

				Intervento i = new Intervento();
				i.setId(rs.getString(1));
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
			
			String insert = "INSERT INTO intervento VALUES ("+ intervento.getId() +", '"
															 + t.timeFormat(intervento.getOraInizio().getTime()) + "',"
															 + " '" + t.timeFormat(intervento.getOraFine().getTime()) + "', "
															 + intervento.getIdSessione() + ", '"
															 + intervento.getDescrizione() + "');";
	        statement.executeUpdate(insert);
		}

		catch (SQLException e) { e.printStackTrace(); }
	}

	public void updateIntervento(Intervento intervento) {

		myTemplates t = new myTemplates();

		try {
			
			String update = "UPDATE intervento SET "
					  	  + "ora_inizio = '"+ t.timeFormat(intervento.getOraInizio().getTime()) +"', "
					      + "ora_fine = '"+ t.timeFormat(intervento.getOraFine().getTime()) + "', "
					      + "descrizione = '" + intervento.getDescrizione()  + "' "
					      + "WHERE id_intervento = " + intervento.getId() + ";";
			
			statement.executeUpdate(update);
		} catch (SQLException e) {  e.getMessage(); }
	}
}
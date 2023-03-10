package DAO;

import java.sql.*;
import java.util.ArrayList;

import Logica.Connessione;
import Logica.Controller;
import Logica.Connessione;

public class Conferenza_ScientificaDAO {
	
	private Connessione connection;
	private Statement statement;
	private Controller controller;
	
	public Conferenza_ScientificaDAO(Controller controller) {
		this.controller = controller;
		this.connection = Connessione.getConnection();
		this.statement = connection.getStatement();
	}
	
	
	
	
	
	
	
	
}



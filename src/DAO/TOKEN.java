package DAO;

import linker.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TOKEN {

    private DBConnection DataBase;
    private Statement statement;
    
    public TOKEN() {

    	DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }
    
    public boolean checkTOKEN(String password) {

        boolean isAdmin = false;

        try {

        	String select = "SELECT * FROM db_token WHERE db_token = '" + password + "';" ;
            ResultSet rs = statement.executeQuery(select);

            while (rs.next()) { isAdmin = true; }

        } catch (SQLException e) { e.getMessage(); }

        return isAdmin;
    }
}
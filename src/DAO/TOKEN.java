package DAO;

import linker.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;


public class TOKEN {

    private DBConnection DataBase;
    private Statement statement;
    
    public TOKEN() {

    	DataBase = DBConnection.getConnection();
        statement = DataBase.getStatement();
    }

    public boolean checkTOKEN(String password) {

        String select = "SELECT * FROM db_token WHERE db_token = '" + password + "';" ;
        boolean isAdmin = false;

        try {

            ResultSet rs = statement.executeQuery(select);

            while (rs.next()) { isAdmin = true; }

        } catch (Exception e) { e.printStackTrace(); }

        return isAdmin;
    }
}
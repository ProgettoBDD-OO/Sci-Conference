package DTO;

import java.util.Calendar;


public class Intervallo {
	
	  private Calendar Durata = Calendar.getInstance();
	  private String Tipo;

	    public Calendar getDurata() {
	        return Durata;
	    }

	    public void setDurata(Calendar durata) {
	        this.Durata = durata;
	    }

	    public String getTipo() {
	        return Tipo;
	    }

	    public void setTipo(String tipo) {
	        this.Tipo = tipo;
	    }
}
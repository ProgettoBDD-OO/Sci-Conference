package DTO;

import java.util.Calendar;

public class Intervento {
	
	private Calendar OraInizio = Calendar.getInstance();
    private Calendar OraFine = Calendar.getInstance();
    private String Partecipanti;
    private String Abstract;

    public Calendar getOrainizio() {
        return OraInizio;
    }

    public void setOrainizio(Calendar orainizio) {
        this.OraInizio = orainizio;
    }

    public Calendar getOrafine() {
        return OraFine;
    }

    public void setOrafine(Calendar orafine) {
        this.OraFine = orafine;
    }

    public String getPartecipanti() {
        return Partecipanti;
    }

    public void setPartecipanti(String partecipanti) {
        this.Partecipanti = partecipanti;
    }

    public String getEstratto() {
        return Abstract;
    }

    public void setEstratto(String estratto) {
        this.Abstract = estratto;
    } 

}
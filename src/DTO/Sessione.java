package DTO;

import java.sql.Date;
import java.util.Calendar;

public class Sessione {
	
	private int Id;
    private String Coordinatore;
    private String KeynoteSpeaker;
    private int IdConferenza;
    private Calendar DataOraInizio = Calendar.getInstance();
    private Calendar DataOraFine = Calendar.getInstance();
    
    
    public Sessione() {
    	
    	
    }
    
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCoordinatore() {
        return Coordinatore;
    }

    public void setCoordinatore(String coordinatore) {
        Coordinatore = coordinatore;
    }

    public String getKeynoteSpeaker() {
        return KeynoteSpeaker;
    }

    public void setKeynoteSpeaker(String keynoteSpeaker) {
        KeynoteSpeaker = keynoteSpeaker;
    }

    public int getIdConferenza() {
        return IdConferenza;
    }

    public void setIdConferenza(int idConferenza) {
        IdConferenza = idConferenza;
    }
    
    public Calendar getDataOraInizio() {
        return DataOraInizio;
    }

    public void setDataOraInizio(Date dataOraInizio) {
        DataOraInizio.setTime(dataOraInizio);
    }

    public Calendar getDataOraFine() {
        return DataOraFine;
    }

    public void setDataOraFine(Date dataOraFine) {
        DataOraFine.setTime(dataOraFine);
    }
}
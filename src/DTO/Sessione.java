package DTO;

import java.sql.Timestamp;
import java.util.Calendar;

public class Sessione {
	
	private String Id;
    private int IdConferenza;
    private Calendar DataOraInizio = Calendar.getInstance();
    private Calendar DataOraFine = Calendar.getInstance();
    private String Locazione;
    private String Coordinatore;
    private String KeynoteSpeaker;
    
    
    public String getId() { return Id; }

    public void setId(String id) { Id = id; }
    

    public int getIdConferenza() { return IdConferenza; }

    public void setIdConferenza(int idConferenza) { IdConferenza = idConferenza; }
    
    
    public Calendar getDataOraInizio() { return DataOraInizio; }

    public void setDataOraInizio(Timestamp dataOraInizio) { DataOraInizio.setTime(dataOraInizio); }
    

    public Calendar getDataOraFine() { return DataOraFine; }

    public void setDataOraFine(Timestamp dataOraFine) { DataOraFine.setTime(dataOraFine); }
    
    
    public String getLocazione() { return Locazione; }

    public void setLocazione(String locazione) { Locazione = locazione; }
    
    
    public String getCoordinatore() { return Coordinatore; }

    public void setCoordinatore(String coordinatore) { Coordinatore = coordinatore; }
    

    public String getKeynoteSpeaker() { return KeynoteSpeaker; }

    public void setKeynoteSpeaker(String keynoteSpeaker) { KeynoteSpeaker = keynoteSpeaker; }
}
package DTO;

import java.sql.Date;
import java.util.Calendar;

public class Sessione {

	private String Id;
    private Calendar DataOraInizio = Calendar.getInstance();
    private Calendar DataOraFine = Calendar.getInstance();
    private String Coordinatore;
    private String KeynoteSpeaker;
    private int IdConferenza;
    private String Locazione;


    public String getId() { return Id; }

    public void setId(String id) { Id = id; }


    public Calendar getDataInizio() { return DataOraInizio; }

    public void setDataInizio(Date date) { DataOraInizio.setTime(date); }
    public void setDataInizio(Calendar calendar) { DataOraInizio = calendar; }

    public Calendar getDataFine() { return DataOraFine; }

    public void setDataFine(Date date) { DataOraFine.setTime(date); }
    public void setDataFine(Calendar calendar) { DataOraFine = calendar; }


    public String getLocazione() { return Locazione; }

    public void setLocazione(String locazione) { Locazione = locazione; }


    public String getCoordinatore() { return Coordinatore; }

    public void setCoordinatore(String coordinatore) { Coordinatore = coordinatore; }


    public String getKeynoteSpeaker() { return KeynoteSpeaker; }

    public void setKeynoteSpeaker(String keynoteSpeaker) { KeynoteSpeaker = keynoteSpeaker; }


    public int getIdConferenza() { return IdConferenza; }

    public void setIdConferenza(int idConferenza) { IdConferenza = idConferenza; }
}
package DTO;

import java.sql.Time;
import java.util.Calendar;

public class Intervento {
	
	private String IdIntervento;
	private Calendar OraInizio = Calendar.getInstance();
    private Calendar OraFine = Calendar.getInstance();
    private String IdSessione;
    private String Descrizione;
    private String Abstract;

    
    public String getIdIntervento() { return IdIntervento; }
    
    public void setIdIntervento(String idIntervento) { IdIntervento = idIntervento; }
    
    
    public Calendar getOrainizio() { return OraInizio; }

    public void setOrainizio(Time orainizio) { OraInizio.setTime(orainizio); }

    
    public Calendar getOrafine() { return OraFine; }

    public void setOrafine(Time orafine) { OraFine.setTime(orafine); }
    
    
    public String getIdSessione() { return IdSessione; }

    public void setIdSessione(String idSessione) { IdSessione = idSessione; }
    
    
    public String getDescrizione() { return Descrizione; }

    public void setDescrizione(String descrizione) { Descrizione = descrizione; }

    
    public String getEstratto() { return Abstract; }

    public void setEstratto(String estratto) { Abstract = estratto; } 
}
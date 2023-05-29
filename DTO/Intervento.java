package DTO;

import java.sql.Time;
import java.util.Calendar;

public class Intervento {

	private String IdIntervento;
	private Calendar OraInizio = Calendar.getInstance();
    private Calendar OraFine = Calendar.getInstance();
    private String IdSessione;
    private String Descrizione;


    public String getId() { return IdIntervento; }

    public void setId(String idIntervento) { IdIntervento = idIntervento; }


    public Calendar getOraInizio() { return OraInizio; }

    public void setOraInizio(Time orainizio) { OraInizio.setTime(orainizio); }
    public void setOraInizio(Calendar calendar) { OraInizio = calendar; }


    public Calendar getOraFine() { return OraFine; }

    public void setOraFine(Time orafine) { OraFine.setTime(orafine); }
    public void setOraFine(Calendar calendar) { OraFine = calendar; }


    public String getIdSessione() { return IdSessione; }

    public void setIdSessione(String idSessione) { IdSessione = idSessione; }


    public String getDescrizione() { return Descrizione; }

    public void setDescrizione(String descrizione) { Descrizione = descrizione; }
}
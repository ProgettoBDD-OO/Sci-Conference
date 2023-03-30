package DTO;

import java.util.Calendar;
import java.util.Date;

public class Conferenza extends ProposteBacheca{
	
	private Calendar DataInizio = Calendar.getInstance();
	private Calendar DataFine = Calendar.getInstance();
	private int IdCollocazione;
	
    
    public Calendar getDataInizio() { return DataInizio; }

    public void setDataInizio(Date dataInizio) { DataInizio.setTime(dataInizio); }

    
    public Calendar getDataFine() { return DataFine; }

    public void setDataFine(Date dataFine) { DataFine.setTime(dataFine); }
    
    
    public int getIdCollocazione() { return IdCollocazione; }
    
    public void setIdCollocazione(int idCollocazione) { IdCollocazione = idCollocazione; }
}
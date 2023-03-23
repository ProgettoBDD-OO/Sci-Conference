package DTO;

import java.util.Calendar;
import java.util.Date;

public class Conferenza extends ConferenzaBacheca{
	
	private Calendar DataInizio = Calendar.getInstance();
	private Calendar DataFine = Calendar.getInstance();
	
	private String NomePrimaParte;
	private String NomeSecondaParte;

    
    public Calendar getDataInizio() { return DataInizio; }

    public void setDataInizio(Date dataInizio) { DataInizio.setTime(dataInizio); }

    
    public Calendar getDataFine() { return DataFine; }

    public void setDataFine(Date dataFine) { DataFine.setTime(dataFine); }
    
    
    public String getNomePrimaParte() { return NomePrimaParte; }
    
    public void setNomePrimaParte(String nomePrimaParte) { NomePrimaParte = nomePrimaParte; }
    
    
    public String getNomeSecondaParte() { return NomeSecondaParte; }
    
    public void setNomeSecondaParte(String nomeSecondaParte) { NomeSecondaParte = nomeSecondaParte; }
}
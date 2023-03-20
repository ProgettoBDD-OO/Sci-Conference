package DTO;

import java.util.Calendar;
import java.util.Date;

public class Conferenza {
	
	private int Id;
	private String Nome;
	private String Descrizione;
	private String Tema;
	private Calendar DataInizio = Calendar.getInstance();
	private Calendar DataFine = Calendar.getInstance();
	
	private String NomePrimaParte;
	private String NomeSecondaParte;
	
	public Conferenza() {}
	
	
	public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    
    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }

    
    public String getDescrizione() { return Descrizione; }

    public void setDescrizione(String descrizione) { Descrizione = descrizione; }

    
    public String getTema() { return Tema; }

    public void setTema(String tema) { Tema = tema; }

    
    public Calendar getDataInizio() { return DataInizio; }

    public void setDataInizio(Date dataInizio) { DataInizio.setTime(dataInizio); }

    
    public Calendar getDataFine() { return DataFine; }

    public void setDataFine(Date dataFine) { DataFine.setTime(dataFine); }
    
    
    public String getNomePrimaParte() { return NomePrimaParte; }
    
    public void setNomePrimaParte(String nomePrimaParte) { NomePrimaParte = nomePrimaParte; }
    
    
    public String getNomeSecondaParte() { return NomeSecondaParte; }
    
    public void setNomeSecondaParte(String nomeSecondaParte) { NomeSecondaParte = nomeSecondaParte; }
}
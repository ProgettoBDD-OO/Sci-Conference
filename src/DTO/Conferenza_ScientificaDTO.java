package DTO;

import java.util.Calendar;
import Logica.Controller;

public class Conferenza_ScientificaDTO {
	
	private Controller controller;

    private int Id;
    private String Nome;
    private String Descrizione;
    private String Tema;
    private Calendar DataInizio = Calendar.getInstance();
    private Calendar DataFine = Calendar.getInstance();

    public Conferenza_ScientificaDTO(Controller controller) {
    	this.controller = controller;
    }


    public int getId() {
        return this.Id;
    }
    
    public void setId(int NewId) {
    	this.Id = NewId;
    }

    public String getNome() {
        return Nome;
    }
    
    public void setNome(String NewNome) {
    	this.Nome = NewNome;
    }
    
    public String getDescrizione() {
    	return Descrizione;
    }
    
    public void setDescrizione(String NewDescrizione) {
    	this.Descrizione = NewDescrizione;
    }

    public String getTema() {
    	return Tema;
    }
    
    public void setTema(String NewTema) {
    	this.Tema = NewTema;
    }
    
    public Calendar getDataInizio() {
        return DataInizio;
    }
    
    public void setDataInizio(Calendar NewDataInizio) {
    	this.DataInizio = NewDataInizio;
    }

    public Calendar getDataFine() {
        return DataFine;
    }
    
    public void setDataFine(Calendar NewDataFine) {
    	this.DataFine = NewDataFine;
    }


    
    
}
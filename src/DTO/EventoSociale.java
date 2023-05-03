package DTO;

import java.util.Calendar;

public class EventoSociale {
	
	private String Nome;
    private String Tipo;
    private String Descrizione;
    private Calendar DataOraInizio = Calendar.getInstance();
    private Calendar DataOraFine = Calendar.getInstance();

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.Descrizione = descrizione;
    }

    public Calendar getDatainizio() {
        return DataOraInizio;
    }

    public void setDatainizio(Calendar datainizio) {
        this.DataOraInizio = datainizio;
    }

    public Calendar getDatafine() {
        return DataOraFine;
    }

    public void setDatafine(Calendar datafine) {
        this.DataOraFine = datafine;
    }
}
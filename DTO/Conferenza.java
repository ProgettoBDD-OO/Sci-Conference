package DTO;

import java.util.Calendar;
import java.util.Date;


public class Conferenza {

	private String Id;
	private String Nome;
	private Calendar DataInizio = Calendar.getInstance();
	private Calendar DataFine = Calendar.getInstance();
	private String Descrizione;
	private String DescrizionePrimaParte;
	private String DescrizioneSecondaParte;
	private String Tema;
	private int IdCollocazione;


	public String getId() {return Id; }

    public void setId(String id) { Id = id; }


    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }


    public Calendar getDataInizio() { return DataInizio; }

    public void setDataInizio(Date dataInizio) { DataInizio.setTime(dataInizio); }
	public void setDataInizio(Calendar calendar) { DataInizio = calendar; }


    public Calendar getDataFine() { return DataFine; }

    public void setDataFine(Date dataFine) { DataFine.setTime(dataFine); }
    public void setDataFine(Calendar calendar) { DataFine = calendar; }


    public String getDescrizione() { return Descrizione; }

    public void setDescrizione(String descrizione) { Descrizione = descrizione; }

    public String getDescrizionePrimaParte() { return DescrizionePrimaParte; }

    public void setDescrizionePrimaParte(String descrizionePrimaParte) { DescrizionePrimaParte = descrizionePrimaParte; }

    public String getDescrizioneSecondaParte() { return DescrizioneSecondaParte; }

    public void setDescrizioneSecondaParte(String descrizioneSecondaParte) { DescrizioneSecondaParte = descrizioneSecondaParte; }

    
    public String getTema() { return Tema; }

    public void setTema(String tema) { Tema = tema;}


    public int getIdCollocazione() { return IdCollocazione; }

    public void setIdCollocazione(int idCollocazione) { IdCollocazione = idCollocazione; }
}
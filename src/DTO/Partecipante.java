package DTO;

public class Partecipante {

	private String Email;
	private String Titolo;
    private String Nome;
    private String Cognome;
    private String Afferenza;
    private String IdIntervento;

    public String getEmail() { return Email; }

    public void setEmail(String email) { Email = email; }


    public String getTitolo() { return Titolo; }

    public void setTitolo(String titolo) { Titolo = titolo; }


    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }


    public String getCognome() { return Cognome; }

    public void setCognome(String cognome) { Cognome = cognome; }


    public String getAfferenza() { return Afferenza; }

    public void setAfferenza(String afferenza) { Afferenza = afferenza; }


    public String getIdIntervento() { return IdIntervento; }

    public void setIdIntervento(String idIntervento) { IdIntervento = idIntervento; }
}
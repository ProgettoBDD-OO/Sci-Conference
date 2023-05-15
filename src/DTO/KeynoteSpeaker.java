package DTO;

public class KeynoteSpeaker {
	
	private String Email;
	private String Titolo;
    private String Nome;
    private String Cognome;
    private String Afferenza;
    
    
    public String getEmail() { return Email; }

    public void setEmail(String email) { this.Email = email; }
    
    
    public String getTitolo() { return Titolo; }

    public void setTitolo(String titolo) { Titolo = titolo; }
    

    public String getNome() { return Nome; }
    
    public void setNome(String nome) { this.Nome = nome; }
    
    
    public String getCognome() { return Cognome; }
    
    public void setCognome(String cognome) { this.Cognome = cognome; }

    
    public String getAfferenza() { return Afferenza; }

    public void setAfferenza(String afferenza) { this.Afferenza = afferenza; }
}
package DTO;

public class Organizzatore {
	
    private String NomeCognome;
    private String Email;
    private String Titolo;
    private String Afferenza;
    

    public String getNomeCognome() {
        return NomeCognome;
    }
    
    public void setNomeCognome(String cognome) {
        this.NomeCognome = cognome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
    
    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public String getAfferenza() {
        return Afferenza;
    }

    public void setAfferenza(String afferenza) {
        this.Afferenza = afferenza;
    }
}
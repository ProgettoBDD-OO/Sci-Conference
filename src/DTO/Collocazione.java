package DTO;

public class Collocazione {
	
	private int Id;
	private String Sede;
	private String Regione;
	
	public String getSede() {
        return Sede;
    }
	
	public void setSede(String sede) {
		this.Sede = sede;
	}

	public String getRegione() { return Regione; }

	public void setRegione(String regione) { Regione = regione; }
}
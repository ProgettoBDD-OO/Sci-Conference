package DTO;

public class Ente {

	private String Nome;
	private int Occorrenze;
	private static int TotaleEnti = 0;


    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }


    public int getOccorrenze() { return Occorrenze; }

    public void setOccorrenze(int nOccorrenze) {

    	Occorrenze = nOccorrenze;
    	TotaleEnti += nOccorrenze;
    }


    public static void azzeraTotale() { TotaleEnti = 0; }

    public static int getTotaleEnti() { return TotaleEnti; }
}
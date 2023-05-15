package myException;

public class NoInterventionException extends Exception {

	public NoInterventionException() { super("Una sessione deve avere almeno un intervento."); }
}
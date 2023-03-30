package myException;

public class DifferentPasswordException extends Exception {
	
	public DifferentPasswordException() { super("Il campo per confermare la password non corrisponde."); }
}
package myException;

public class EmptyFieldException extends Exception {

	public EmptyFieldException() { super("Uno o più campi sono vuoti."); }
}
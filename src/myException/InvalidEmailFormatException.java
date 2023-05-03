package myException;

public class InvalidEmailFormatException extends Exception{

	public InvalidEmailFormatException() { super("Formato email non valido."); }
}
package myException;

public class EmailAlreadyExistsException extends Exception{
	
	public EmailAlreadyExistsException() { super("L'email è stata gia usata."); }
}
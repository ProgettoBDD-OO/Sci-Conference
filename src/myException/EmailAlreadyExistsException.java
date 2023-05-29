package myException;

public class EmailAlreadyExistsException extends Exception {

	public EmailAlreadyExistsException() { super("Questa email risulta già registrata."); }
}
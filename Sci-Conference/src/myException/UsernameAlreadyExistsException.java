package myException;

public class UsernameAlreadyExistsException extends Exception {

	public UsernameAlreadyExistsException() { super("Username non disponibile."); }
}
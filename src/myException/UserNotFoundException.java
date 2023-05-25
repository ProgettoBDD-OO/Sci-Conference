package myException;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() { super("Utente non trovato nel Database.");	}
}
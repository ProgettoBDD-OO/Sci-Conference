package myException;

public class WrongPasswordException extends Exception {

	public WrongPasswordException() { super("Password errata."); }
}
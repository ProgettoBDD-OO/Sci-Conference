package myException;

public class ShortPswrdException extends Exception{
	
	public ShortPswrdException() { super("Password troppo corta"); }
}
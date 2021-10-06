package exception;

public class PersonNotFoundException extends Exception {
	public PersonNotFoundException(String message) {
		super(message);
		// Exception이 처리하도록 유도
	}
}

package exception;

public class DuplicateTelException extends Exception {
	public DuplicateTelException(String message) {
		super(message);
		// Exception이 처리하도록 유도
	}
}

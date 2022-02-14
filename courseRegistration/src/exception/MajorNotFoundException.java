package exception;

public class MajorNotFoundException extends Exception {
	public MajorNotFoundException() {}
	public MajorNotFoundException(String msg) {
		super(msg);
	}
}
package in.vaish.exception;

public class CustomDuplicateEmailException extends RuntimeException {

	public CustomDuplicateEmailException(String msg) {
		super(msg);
	}
}

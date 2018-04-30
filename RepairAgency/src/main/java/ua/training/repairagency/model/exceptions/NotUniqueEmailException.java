package ua.training.repairagency.model.exceptions;

public class NotUniqueEmailException extends NotUniqueParamException {

	private static final long serialVersionUID = 1L;

	public NotUniqueEmailException() {
		super();
	}

	public NotUniqueEmailException(String message) {
		super(message);
	}
	
	public NotUniqueEmailException(Throwable e) {
		super(e);
	}
	
}

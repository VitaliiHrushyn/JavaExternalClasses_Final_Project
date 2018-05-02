package ua.training.repairagency.model.exceptions;

public class NotUniqueFieldValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueFieldValueException() {
		super();
	}

	public NotUniqueFieldValueException(String message) {
		super(message);
	}
	
	public NotUniqueFieldValueException(Throwable e) {
		super(e);
	}
	
}

package ua.training.repairagency.model.exceptions;

public class NotUniqueEmailException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueEmailException() {
		super();
	}

	public NotUniqueEmailException(String message) {
		super(message);
	}
	
}

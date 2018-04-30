package ua.training.repairagency.model.exceptions;

public class NotUniqueLoginException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueLoginException() {
		super();
	}

	public NotUniqueLoginException(String message) {
		super(message);
	}
	
	public NotUniqueLoginException(Throwable e) {
		super(e);
	}
}

package ua.training.repairagency.model.exceptions;

public class NotUniquePhoneException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniquePhoneException() {
		super();
	}

	public NotUniquePhoneException(String message) {
		super(message);
	}
	
}

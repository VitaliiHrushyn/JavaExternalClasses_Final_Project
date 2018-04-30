package ua.training.repairagency.model.exceptions;

public class NotUniqueLoginException extends NotUniqueParamException {

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

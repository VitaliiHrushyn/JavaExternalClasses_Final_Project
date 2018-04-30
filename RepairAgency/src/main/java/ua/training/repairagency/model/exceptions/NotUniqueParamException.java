package ua.training.repairagency.model.exceptions;

public abstract class NotUniqueParamException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueParamException() {
		super();
	}

	public NotUniqueParamException(String message) {
		super(message);
	}
	
	public NotUniqueParamException(Throwable e) {
		super(e);
	}
	
}

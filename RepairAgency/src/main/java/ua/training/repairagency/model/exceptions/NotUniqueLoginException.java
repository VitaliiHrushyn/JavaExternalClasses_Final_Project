package ua.training.repairagency.model.exceptions;
@Deprecated
public class NotUniqueLoginException extends NotUniqueFieldValueException {

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

package ua.training.repairagency.model.exceptions;
@Deprecated
public class NotUniquePhoneException extends NotUniqueFieldValueException {

	private static final long serialVersionUID = 1L;

	public NotUniquePhoneException() {
		super();
	}

	public NotUniquePhoneException(String message) {
		super(message);
	}
	
	public NotUniquePhoneException(Throwable e) {
		super(e);
	}
	
}

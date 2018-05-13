package ua.training.repairagency.model.exceptions;

public class OutOfDateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public OutOfDateException() {
		super();
	}

	public OutOfDateException(String message) {
		super(message);
	}
	
	public OutOfDateException(Throwable e) {
		super(e);
	}

}

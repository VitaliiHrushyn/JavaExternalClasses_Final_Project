package ua.training.repairagency.model.exceptions;

public class OutOfDateDataException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OutOfDateDataException() {
		super();
	}

	public OutOfDateDataException(String message) {
		super(message);
	}
	
	public OutOfDateDataException(Throwable e) {
		super(e);
	}

}

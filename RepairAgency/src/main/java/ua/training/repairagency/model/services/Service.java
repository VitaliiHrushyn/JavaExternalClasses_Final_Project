package ua.training.repairagency.model.services;


public interface Service {
	//TODO properly
	default <T, E> T execute(E param) {
		throw new UnsupportedOperationException();
	}
	
	default <T> T execute() {
		throw new UnsupportedOperationException();
	}
	
//	<T, E> T execute(E param);

}

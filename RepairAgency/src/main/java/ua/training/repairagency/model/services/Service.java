package ua.training.repairagency.model.services;

import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public interface Service {
	//TODO properly

	<T> T execute() throws NotUniqueFieldValueException;

}

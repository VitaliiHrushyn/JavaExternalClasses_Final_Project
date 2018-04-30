package ua.training.repairagency.model.dao.interfaces;

import java.util.List;

import ua.training.repairagency.model.exceptions.NotUniqueEmailException;
import ua.training.repairagency.model.exceptions.NotUniqueLoginException;
import ua.training.repairagency.model.exceptions.NotUniquePhoneException;

public interface GenericDAO<T> extends AutoCloseable {
	
	T create(T entity) throws NotUniqueLoginException, NotUniqueEmailException, NotUniquePhoneException;
	
	T update(T entity);
	
	T getById(int id);
	
	List<T> getAll(boolean eager);
	
	T delete(T entity);

	T delete(int id);
	
	T getByParam(String value);

}

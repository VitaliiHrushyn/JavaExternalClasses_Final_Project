package ua.training.repairagency.model.dao.interfaces;

import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
	
	T create(T entity);
	
	T update(T entity);
	
	T getById(int id);
	
	List<T> getAll(boolean eager);
	
	T delete(T entity);

	T delete(int id);

}

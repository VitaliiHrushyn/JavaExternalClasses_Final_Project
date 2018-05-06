package ua.training.repairagency.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
	
	T create(T entity) throws SQLException;
	
	T update(T entity) throws SQLException;
	
	T getById(int id);
	
	List<T> getAll(boolean eager);
	
	T delete(T entity);

	T delete(int id);
	
	T getByParam(String name, String value);

}

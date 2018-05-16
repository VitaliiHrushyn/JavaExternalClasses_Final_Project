package ua.training.repairagency.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import ua.training.repairagency.model.exceptions.OutOfDateDataException;

public interface GenericDAO<T> extends AutoCloseable {
	
	T create(T entity) throws SQLException;
	
	T update(T entity) throws OutOfDateDataException, SQLException;
	
	T getById(int id);
	
	List<T> getAll(int limit, int offset);
	
	T delete(T entity);

}

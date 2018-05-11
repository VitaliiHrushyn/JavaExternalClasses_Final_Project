package ua.training.repairagency.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> extends AutoCloseable {
	
	T create(T entity) throws SQLException;
	
	T update(T entity) throws SQLException;
	
	T getById(int id);
	
	List<T> getAll();
	
	T delete(T entity);

}

package ua.training.repairagency.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.training.repairagency.model.dao.interfaces.GenericDAO;
import ua.training.repairagency.model.entities.Entity;

public abstract class AbstractDAO<T extends Entity> implements GenericDAO<T> {	
	
	private Connection connection;
	
	public AbstractDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public abstract String getCreateQuery();
	public abstract void fillCreateStatement(PreparedStatement statement, T entity) throws SQLException;
		
	public abstract String getUpdateQuery();
	public abstract void fillUpdateStatement(PreparedStatement statement, T entity) throws SQLException;
		
	public abstract String getByIDQuery();
	public abstract String getDeleteQuery();
	public abstract String getAllQuery();
//	public abstract String getJoinQuery();
	
	public abstract T extractEntity(ResultSet rs, boolean eager) throws SQLException;


	@Override
	public T create(T entity) { 
		try(PreparedStatement statement = 
				connection.prepareStatement(getCreateQuery(), Statement.RETURN_GENERATED_KEYS)) {
			fillCreateStatement(statement, entity);
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			if (keys.next()) {
				return getById(keys.getInt(1));
			} else {				
				return null;	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override	
	public T getById(int id) {
		T entity = null;		
		try(PreparedStatement statement = connection.prepareStatement(getByIDQuery())) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				entity = extractEntity(rs, true);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
		return entity;
	}	

	@Override
	public T update(T entity) {
		try(PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {
			fillUpdateStatement(statement, entity);
			if (statement.executeUpdate() > 0) {
				return entity;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}	

	@Override
	public T delete(T entity) {
		try(PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {
			statement.setInt(1, entity.getId());
			if (statement.executeUpdate() > 0) {
				return entity;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public T delete(int id) {
		try(PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {
			statement.setInt(1, id);
			if (statement.executeUpdate() > 0) {
				return getById(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public List<T> getAll(boolean eager) {
		Map<Integer, T> uniqueEnteties = new HashMap<>();
		try(PreparedStatement statement = connection.prepareStatement(getAllQuery())) {
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				T entity = extractEntity(rs, eager);
				uniqueEnteties.putIfAbsent(entity.getId(), entity);;	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return new ArrayList<>(uniqueEnteties.values());
	}
	
//	public List<T> getJoin(int id) {
//		Map<Integer, T> uniqueEnteties = new HashMap<>();
//		try(PreparedStatement statement = connection.prepareStatement(getJoinQuery())) {
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();			
//			while(rs.next()) {
//				T entity = extractEntity(rs, false);
//				uniqueEnteties.putIfAbsent(entity.getId(), entity);;	
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}				
//		return new ArrayList<>(uniqueEnteties.values());
//	}


	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
	}	

}

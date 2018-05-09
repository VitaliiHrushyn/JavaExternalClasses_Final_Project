package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ua.training.repairagency.model.constants.Resource;
import ua.training.repairagency.model.dao.interfaces.GenericDAO;
import ua.training.repairagency.model.entities.Entity;

public abstract class AbstractDAO<T extends Entity> implements GenericDAO<T> {	
	
	protected ResourceBundle columnBundle = ResourceBundle.getBundle(Resource.DB_COLUMNS);
	protected ResourceBundle queryBundle = ResourceBundle.getBundle(Resource.DB_QUERIES);
	protected Connection connection;
	
	public AbstractDAO(Connection connection) {
		super();
		this.connection = connection;
	}	

	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
			//e.printStackTrace();
		}		
	}	

}

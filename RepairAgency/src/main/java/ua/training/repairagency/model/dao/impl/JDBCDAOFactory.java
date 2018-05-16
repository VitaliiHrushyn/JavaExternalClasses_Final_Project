package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import ua.training.repairagency.model.dao.ConnectionPoolHolder;
import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.dao.interfaces.UserDAO;

public class JDBCDAOFactory extends DAOFactory {
	
	private DataSource dataSource = ConnectionPoolHolder.getDataSource();
	
	private Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public UserDAO createUserDAO() {
		return new UserDAOImpl(getConnection());
	}

	@Override
	public ApplicationDAO createApplicationDAO() {
		return new ApplicationDAOimpl(getConnection());
	}
	@Override
	public TestimonialDAO createTestimonialDAO() {
		return new TestimonialDAOImpl(getConnection());
	}

}
 
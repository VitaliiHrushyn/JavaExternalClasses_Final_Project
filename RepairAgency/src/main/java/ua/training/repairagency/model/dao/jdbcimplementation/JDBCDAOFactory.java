package ua.training.repairagency.model.dao.jdbcimplementation;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import ua.training.repairagency.model.dao.ConnectionPoolHolder;
import ua.training.repairagency.model.dao.DAOFactory;

public class JDBCDAOFactory extends DAOFactory {
	
	private DataSource dataSource = ConnectionPoolHolder.getDataSource();
	
	@SuppressWarnings("unused")
	private Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
// TODO
//	@Override
//	public CarDAO createCarDAO() {
//		return new CarDAO(getConnection());
//	}
//
//	@Override
//	public DriverDAO createDriverDAO() {
//		return new DriverDAO(getConnection());
//	}
//	
//	@Override
//	public CarDriverDAO createCarDriverDAO() {
//		return new CarDriverDAO(getConnection());
//	}

}
 
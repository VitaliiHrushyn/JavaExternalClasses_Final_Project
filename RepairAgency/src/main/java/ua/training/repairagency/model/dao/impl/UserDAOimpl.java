package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static ua.training.repairagency.model.dao.constants.QueryConstants.*;
import static ua.training.repairagency.model.dao.constants.ColumnConstants.*;
import static ua.training.repairagency.model.dao.constants.ResourceConstants.*;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOimpl extends AbstractDAO<User> implements UserDAO {
	
	private static final String QUERY_BUNDLE_NAME = RESOURCE_DB_QUERIES;
	private static final String COLUMN_BUNDLE_NAME = RESOURCE_DB_COLUMNS;
	
	private ResourceBundle columnBundle;
	private ResourceBundle queryBundle;
		
	public UserDAOimpl(Connection connection) {
		super(connection);
		queryBundle = ResourceBundle.getBundle(QUERY_BUNDLE_NAME);
		columnBundle = ResourceBundle.getBundle(COLUMN_BUNDLE_NAME);
	}
		
	@Override
	public String getAllQuery() {
		return queryBundle.getString(USER_GET_ALL);
	}
	
	@Override
	public String getByIDQuery() {
		return queryBundle.getString(USER_GET_BY_ID);
	}
	
	@Override
	String getByParamQuery() {
		return queryBundle.getString(USER_GET_BY_LOGIN);
	}
	
	@Override
	public String getDeleteQuery() {
		return queryBundle.getString(USER_DELETE);
	}	
	
	@Override
	public String getCreateQuery() {
		return queryBundle.getString(USER_INSERT);
	}
		
	@Override
	public void fillCreateStatement(PreparedStatement statement, User user) throws SQLException {
		statement.setString(1, user.getRole().toString());
		statement.setString(2, user.getName());
		statement.setString(3, user.getLogin());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPhone());
	}
	
	@Override
	public String getUpdateQuery() {
		return queryBundle.getString(USER_UPDATE);
	}
	
	@Override
	public void fillUpdateStatement(PreparedStatement statement, User user) throws SQLException {
		statement.setString(1, user.getRole().toString());
		statement.setString(2, user.getName());
		statement.setString(3, user.getLogin());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPhone());
		statement.setInt(7, user.getId());		
	}
	
	@Override
	public User extractEntity(ResultSet rs, boolean eager) throws SQLException {
		User user = new UserImpl();
		user.setId(rs.getInt(columnBundle.getString(USER_ID)));
		user.setRole(UserRole.valueOf(rs.getString(columnBundle.getString(USER_ROLE))));
		user.setName(rs.getString(columnBundle.getString(USER_NAME)));
		user.setLogin(rs.getString(columnBundle.getString(USER_LOGIN)));
		user.setPassword(rs.getString(columnBundle.getString(USER_PASSWORD)));
		user.setEmail(rs.getString(columnBundle.getString(USER_EMAIL)));
		user.setPhone(rs.getString(columnBundle.getString(USER_PHONE)));		
		if (eager) {
//TODO				user.setApplications();
		}
		return user;
	}

//		private List<Driver> extractUniqueDrivers(ResultSet rs) throws SQLException {
//			try(AbstractDAO<Driver> driverDAO = DAOFactory.getInstance().createDriverDAO()){
//				List<Driver> drivers = driverDAO.getWhere(rs.getInt(ID));
//				return drivers;
//			}		
//		}

	

	
		
	
	
	

		
//		@Override
//		public String getJoinQuery() {
//			return null; //TODO
//		}

}

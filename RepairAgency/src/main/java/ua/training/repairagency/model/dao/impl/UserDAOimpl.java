package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static ua.training.repairagency.model.dao.constants.QueryConstants.*;
import static ua.training.repairagency.model.dao.constants.ColumnConstants.*;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOimpl extends AbstractDAO<User> implements UserDAO {
	
	private static final String QUERY_BUNDLE_NAME = "database/db_queries";
	private static final String COLUMN_BUNDLE_NAME = "database/db_columns";
	
	private static ResourceBundle queryBundle = ResourceBundle.getBundle(QUERY_BUNDLE_NAME);
	private static ResourceBundle columnBundle = ResourceBundle.getBundle(COLUMN_BUNDLE_NAME);
		
	/* column names */
	private static final String ID = columnBundle.getString(USER_ID);
	private static final String ROLE = columnBundle.getString(USER_ROLE);
	private static final String NAME = columnBundle.getString(USER_NAME);
	private static final String LOGIN = columnBundle.getString(USER_LOGIN);
	private static final String PASSWORD = columnBundle.getString(USER_PASSWORD);
	private static final String EMAIL = columnBundle.getString(USER_EMAIL);
	private static final String PHONE = columnBundle.getString(USER_PHONE);
		
	/* queries */
	private static final String GET_BY_ID = queryBundle.getString(USER_GET_BY_ID);
	private static final String GET_ALL = queryBundle.getString(USER_GET_ALL);
	private static final String DELETE = queryBundle.getString(USER_DELETE);
	private static final String INSERT = queryBundle.getString(USER_INSERT);
	private static final String UPDATE = queryBundle.getString(USER_UPDATE);
	private static final String GET_BY_LOGIN = queryBundle.getString(USER_GET_BY_LOGIN);

		public UserDAOimpl(Connection connection) {
			super(connection);
//			queryBundle = ResourceBundle.getBundle(QUERY_BUNDLE_NAME);
//			columnBundle = ResourceBundle.getBundle(COLUMN_BUNDLE_NAME);
		}
		
		@Override
		public String getCreateQuery() {
			return INSERT;
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
		public User extractEntity(ResultSet rs, boolean eager) throws SQLException {
			User user = new UserImpl();
			user.setId(rs.getInt(ID));
			user.setRole(UserRole.valueOf(rs.getString(ROLE)));
			user.setName(rs.getString(NAME));
			user.setLogin(rs.getString(LOGIN));
			user.setPassword(rs.getString(PASSWORD));
			user.setEmail(rs.getString(EMAIL));
			user.setPhone(rs.getString(PHONE));
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

		@Override
		public String getByIDQuery() {
			return GET_BY_ID;
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
		public String getUpdateQuery() {
			return UPDATE;
		}

		@Override
		public String getDeleteQuery() {
			return DELETE;
		}

		@Override
		public String getAllQuery() {
			return GET_ALL;
		}

		@Override
		String getByParamQuery() {
			System.out.println("GET_BY_LOGIN: "+GET_BY_LOGIN);
			return GET_BY_LOGIN;
		}

		
//		@Override
//		public String getJoinQuery() {
//			return null; //TODO
//		}

}

package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ua.training.repairagency.model.dao.constants.QueryConstants.*;
import static ua.training.repairagency.model.dao.constants.ColumnConstants.*;

import ua.training.repairagency.model.dao.AbstractDAO;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOimpl extends AbstractDAO<User> implements UserDAO {

		public UserDAOimpl(Connection connection) {
			super(connection);
		}

		/* data base table name */
		private static final String TABLE_NAME = USER_TABLE_NAME;
		
		/* column names */
		private static final String ID = USER_ID;
		private static final String ROLE = USER_ROLE;
		private static final String NAME = USER_NAME;
		private static final String LOGIN = USER_LOGIN;
		private static final String PASSWORD = USER_PASSWORD;
		private static final String EMAIL = USER_EMAIL;
		private static final String PHONE = USER_PHONE;
		
		/* queries */
		private static final String GET_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = ?;";
		private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME + ";";
		private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = ?;";
//		private static final String GET_JOIN_WHERE = "SELECT * FROM User "
//				+ "JOIN User_driver ON User.idUser = User_driver.idUser "
//				+ "JOIN driver ON driver.iddriver = User_driver.iddriver "
//				+ " WHERE " + DRIVER_ID + " = ?;";
		
		private static final String INSERT = INSERT_USER;
		private static final String UPDATE = UPDATE_USER;

		@Override
		public String getCreateQuery() {
			return INSERT;
		}
		
		@Override
		public void fillCreateStatement(PreparedStatement statement, User user) throws SQLException {
			statement.setString(1, user.getRole().toString());
			statement.setString(2, user.getName());
			statement.setString(2, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(2, user.getEmail());
			statement.setString(2, user.getPhone());
		}

		@Override
		public User extractEntity(ResultSet rs, boolean eager) throws SQLException {
			User user = new UserImpl();
			user.setId(rs.getInt(USER_ID));
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

//		@Override
//		public String getJoinQuery() {
//			return null; //TODO
//		}

}

package ua.training.repairagency.model.dao.impl;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {
		
	public UserDAOImpl(Connection connection) {
		super(connection);
	}
		
	@Override
	public String getAllQuery() {
		return queryBundle.getString(Query.USER_GET_ALL);
	}
	
	@Override
	public String getByIDQuery() {
		return queryBundle.getString(Query.USER_GET_BY_ID);
	}
	
	@Override
	String getByParamQuery(String name) {
		if (name.equals(Column.USER_LOGIN)) {
			return queryBundle.getString(Query.USER_GET_BY_LOGIN);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String getDeleteQuery() {
		return queryBundle.getString(Query.USER_DELETE);
	}	
	
	@Override
	public String getCreateQuery() {
		return queryBundle.getString(Query.USER_INSERT);
	}
		
	@Override
	public void fillCreateStatement(PreparedStatement statement, User user) throws SQLException {
		statement.setString(1, user.getRole().toString());
		statement.setString(2, user.getName());
		statement.setString(3, user.getSurname());
		statement.setString(4, user.getLogin());
		statement.setString(5, user.getPassword());
		statement.setString(6, user.getEmail());
		statement.setString(7, user.getPhone());
	}
	
	@Override
	public String getUpdateQuery() {
		return queryBundle.getString(Query.USER_UPDATE);
	}
	
	@Override
	public void fillUpdateStatement(PreparedStatement statement, User user) throws SQLException {
		statement.setString(1, user.getRole().toString());
		statement.setString(2, user.getName());
		statement.setString(3, user.getSurname());
		statement.setString(4, user.getLogin());
		statement.setString(5, user.getPassword());
		statement.setString(6, user.getEmail());
		statement.setString(7, user.getPhone());
		statement.setInt(8, user.getId());		
	}
	
	@Override
	public User extractEntity(ResultSet rs, boolean eager) throws SQLException {
		User user = new UserImpl();
		user.setId(rs.getInt(columnBundle.getString(Column.USER_ID)));
		user.setRole(UserRole.valueOf(rs.getString(columnBundle.getString(Column.USER_ROLE))));
		user.setName(rs.getString(columnBundle.getString(Column.USER_NAME)));
		user.setSurname(rs.getString(columnBundle.getString(Column.USER_SURNAME)));
		user.setLogin(rs.getString(columnBundle.getString(Column.USER_LOGIN)));
		user.setPassword(rs.getString(columnBundle.getString(Column.USER_PASSWORD)));
		user.setEmail(rs.getString(columnBundle.getString(Column.USER_EMAIL)));
		user.setPhone(rs.getString(columnBundle.getString(Column.USER_PHONE)));		
		
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

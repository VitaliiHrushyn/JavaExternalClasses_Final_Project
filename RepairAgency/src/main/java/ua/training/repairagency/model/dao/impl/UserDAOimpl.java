package ua.training.repairagency.model.dao.impl;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.constants.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOimpl extends AbstractDAO<User> implements UserDAO {
	
	private ResourceBundle columnBundle = ResourceBundle.getBundle(Resource.DB_COLUMNS);
	private ResourceBundle queryBundle = ResourceBundle.getBundle(Resource.DB_QUERIES);
		
	public UserDAOimpl(Connection connection) {
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
	String getByParamQuery() {
		return queryBundle.getString(Query.USER_GET_BY_LOGIN);
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
		statement.setString(3, user.getLogin());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPhone());
	}
	
	@Override
	public String getUpdateQuery() {
		return queryBundle.getString(Query.USER_UPDATE);
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
		user.setId(rs.getInt(columnBundle.getString(Column.USER_ID)));
		user.setRole(UserRole.valueOf(rs.getString(columnBundle.getString(Column.USER_ROLE))));
		user.setName(rs.getString(columnBundle.getString(Column.USER_NAME)));
		user.setLogin(rs.getString(columnBundle.getString(Column.USER_LOGIN)));
		user.setPassword(rs.getString(columnBundle.getString(Column.USER_PASSWORD)));
		user.setEmail(rs.getString(columnBundle.getString(Column.USER_EMAIL)));
		user.setPhone(rs.getString(columnBundle.getString(Column.USER_PHONE)));		
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

package ua.training.repairagency.model.dao.impl;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {
		
	public UserDAOImpl(Connection connection) {
		super(connection);
	}

	
	public User extractUser(ResultSet rs) throws SQLException {
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

	@Override
	public User getByLogin(String login) {
		User user = null;		
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.USER_GET_BY_LOGIN))) {
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
		return user;
	}


	@Override
	public User create(User user) throws SQLException { 
		try(PreparedStatement statement = 
				connection.prepareStatement(queryBundle.getString(Query.USER_INSERT), Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, user.getRole().toString());
			statement.setString(2, user.getName());
			statement.setString(3, user.getSurname());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getPhone());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			if (keys.next()) {
				return getById(keys.getInt(1));
			} else {				
				return null;	
			}
		}
	}
	

	@Override	
	public User getById(int id) {	
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.USER_GET_BY_ID))) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return extractUser(rs);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
		return null;
	}	

	@Override
	public User update(User user) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.USER_UPDATE))) {
			statement.setString(1, user.getRole().toString());
			statement.setString(2, user.getName());
			statement.setString(3, user.getSurname());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getPhone());
			statement.setInt(8, user.getId());
			if (statement.executeUpdate() > 0) {
				return user;
			}
		}
		return null;
	}	

	@Override
	public User delete(User user) {
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.USER_DELETE))) {
			statement.setInt(1, user.getId());
			if (statement.executeUpdate() > 0) {
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public List<User> getAll(boolean eager) {
		List<User> users = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.USER_GET_ALL))) {
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				users.add(extractUser(rs));	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return users;
	}


}

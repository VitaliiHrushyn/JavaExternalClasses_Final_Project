package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.services.interfaces.ServiceFactory;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;

public class ApplicationDAOImpl extends AbstractDAO<Application> implements ApplicationDAO {

	public ApplicationDAOImpl(Connection connection) {
		super(connection);
	}
	
	public Application create(Application application) throws SQLException { 
		try(PreparedStatement statement = 
				connection.prepareStatement(queryBundle.getString(Query.APPLICATION_INSERT), 
															Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, application.getStatus().toString());
			statement.setString(2, application.getDescription());
			statement.setInt(3, application.getCustomer().getId());
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
	public Application getById(int id) {
		Application application = null;		
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_GET_BY_ID))) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				application = extractApplication(rs, true);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
		return application;
	}
	
	public List<Application> getAll(boolean eager) {
		List<Application> applications = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_GET_ALL))) {
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				applications.add(extractApplication(rs, eager));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return applications;
	}
	
	@Override
	public Application update(Application application) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_UPDATE))) {
//	TODO		statement.setString(1, 1);
			if (statement.executeUpdate() > 0) {
				return application;
			}
		}
		return null;
	}	

	@Override
	public Application delete(Application application) {
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_DELETE))) {
			statement.setInt(1, application.getId());
			if (statement.executeUpdate() > 0) {
				return application;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}

	
	public Application extractApplication(ResultSet rs, boolean eager) throws SQLException {
		Application application = new ApplicationImpl();
		application.setId(rs.getInt(columnBundle.getString(Column.APPLICATION_ID)));
		application.setStatus(AppStatus.valueOf((rs.getString(columnBundle.getString(Column.APPLICATION_STATUS)))));
		application.setDescription(rs.getString(columnBundle.getString(Column.APPLICATION_DESCRIPTION)));
		application.setManagerComment(rs.getString(columnBundle.getString(Column.APPLICATION_MANAGER_COMMENT)));
		application.setPrice(rs.getBigDecimal(columnBundle.getString(Column.APPLICATION_PRICE)));
		application.setCustomer(ServiceFactory.getInstance().createUserService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_CUSTOMER_ID))));
		application.setWorkman(ServiceFactory.getInstance().createUserService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_WORKMAN_ID))));
//TODO		application.setTestimonial(ServiceFactory.getInstance().createTestimonialService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_TESTIMONIAL_ID))));
		application.setCreatTime(rs.getDate(columnBundle.getString(Column.APPLICATION_CREATE_TIME)));
		
		return application;
	}
	
	@Override	
	public List<Application> getAllByParam(String name, String value) {
	//	Map<Integer, Application> uniqueEnteties = new HashMap<>();
		List <Application> applications = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID))) {
			statement.setString(1, value);
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				applications.add(extractApplication(rs, false));	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return applications;
	}
	
}

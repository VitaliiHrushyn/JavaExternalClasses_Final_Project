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
import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;

public class ApplicationDAOimpl extends AbstractDAO<Application> implements ApplicationDAO {

	public ApplicationDAOimpl(Connection connection) {
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
				application = extractApplication(rs);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
		return application;
	}
	
	public List<Application> getAll(int limit, int offset) {
		List<Application> applications = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(queryBundle.getString(Query.APPLICATION_GET_ALL))) {
			statement.setInt(1, limit);
			statement.setInt(2, offset);
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				applications.add(extractApplication(rs));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return applications;
	}
	
	@Override
	public Application update(Application application) throws OutOfDateDataException {
		try(PreparedStatement statement = connection
										.prepareStatement(queryBundle.getString(Query.APPLICATION_UPDATE))) {
						
			fillUpdateStatement(application, statement);
			
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			
			int previouseVersionId = getById(application.getId()).getVersionId();
			if (previouseVersionId == application.getVersionId()) {	
				
				statement.executeUpdate();
				int currentVersionId = getById(application.getId()).getVersionId();
				
				if (currentVersionId == previouseVersionId + 1) {
					connection.commit();
					connection.setAutoCommit(true);
				} else {
					connection.rollback();
					connection.setAutoCommit(true);
					throw new OutOfDateDataException();
				}
			} else {
				throw new OutOfDateDataException();
			}
			
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}
		return application;
	}

	private void fillUpdateStatement(Application application, PreparedStatement statement)
																			throws SQLException {
		statement.setString(1, application.getStatus().toString());
		statement.setString(2, application.getDescription());
		statement.setString(3, application.getManagerComment());
		statement.setBigDecimal(4, application.getPrice());
		if (application.getCustomer() != null) {
			statement.setInt(5, application.getCustomer().getId());
		} else {
			statement.setNull(5, java.sql.Types.INTEGER);
		}
		if (application.getWorkman() != null) {
			statement.setInt(6, application.getWorkman().getId());
		} else {
			statement.setNull(6, java.sql.Types.INTEGER);
		}
		if (application.getTestimonial() != null) {
			statement.setInt(7, application.getTestimonial().getId());
		} else {
			statement.setInt(7, java.sql.Types.INTEGER);
		}
		statement.setInt(8, application.getId());
		
	}	

	@Override
	public Application delete(Application application) {
		try(PreparedStatement statement = connection
										.prepareStatement(queryBundle.getString(Query.APPLICATION_DELETE))) {
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

	
	public Application extractApplication(ResultSet rs) throws SQLException {
		Application application = new ApplicationImpl();
		application.setId(rs.getInt(columnBundle.getString(Column.APPLICATION_ID)));
		application.setStatus(AppStatus.valueOf((rs.getString(columnBundle.getString(Column.APPLICATION_STATUS)))));
		application.setDescription(rs.getString(columnBundle.getString(Column.APPLICATION_DESCRIPTION)));
		application.setManagerComment(rs.getString(columnBundle.getString(Column.APPLICATION_MANAGER_COMMENT)));
		application.setPrice(rs.getBigDecimal(columnBundle.getString(Column.APPLICATION_PRICE)));
		application.setCustomer(ServiceFactory.getInstance().createUserService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_CUSTOMER_ID))));
		application.setWorkman(ServiceFactory.getInstance().createUserService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_WORKMAN_ID))));
		application.setTestimonial(ServiceFactory.getInstance().createTestimonialService().getById(rs.getInt(columnBundle.getString(Column.APPLICATION_TESTIMONIAL_ID))));
		application.setCreateTime((rs.getTimestamp(columnBundle.getString(Column.APPLICATION_CREATE_TIME))).toLocalDateTime());
		application.setLastUpdateTime(rs.getTimestamp(columnBundle.getString(Column.APPLICATION_LAST_UPDATE)));
		application.setVersionId(rs.getInt(columnBundle.getString(Column.APPLICATION_VERSION_ID)));
		
		return application;
	}
	
	@Override	
	public List<Application> getAllByQueryWithLimitAndOffset(String query, String... values) {
		List <Application> applications = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(query)) {
			fillStatementWithLimitAndOffset(statement, values);
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				applications.add(extractApplication(rs));	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return applications;
	}

	private void fillStatementWithLimitAndOffset(PreparedStatement statement, String... values) throws SQLException {
		for (int i = 0; i < values.length - 2; i++) {
			statement.setString(i+1, values[i]);
		}
		for (int i = values.length - 2; i < values.length; i++) {
			statement.setInt(i+1, Integer.valueOf(values[i]));
		}
	}

	@Override
	public int coutnRowsByQuery(String query, String... values) {
		try(PreparedStatement statement = connection
											.prepareStatement(queryBundle.getString(query))) {
			fillCoutRowsStatement(statement, values);
			ResultSet rs = statement.executeQuery();
			rs.next() ;
			return rs.getInt("total");			
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}		
	}

	private void fillCoutRowsStatement(PreparedStatement statement, String[] values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setString(i+1, values[i]);
		}
	}	
	
}

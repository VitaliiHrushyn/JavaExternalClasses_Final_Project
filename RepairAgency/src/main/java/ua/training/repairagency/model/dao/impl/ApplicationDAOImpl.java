package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.services.interfaces.ServiceFactory;

public class ApplicationDAOImpl extends AbstractDAO<Application> implements ApplicationDAO {

	public ApplicationDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public String getCreateQuery() {
		return queryBundle.getString(Query.APPLICATION_INSERT);
	}

	@Override
	public void fillCreateStatement(PreparedStatement statement, Application application) throws SQLException {
		statement.setString(1, application.getStatus().toString());
		statement.setString(2, application.getDescription());
		//statement.setString(3, application.getManagerComment());
		//statement.setBigDecimal(4, application.getPrice());
		statement.setInt(3, application.getCustomer().getId());
		//statement.setInt(6, application.getWorkman().getId());
		//statement.setInt(7, application.getTestimonial().getId());
				
	}

	@Override
	public String getUpdateQuery() {
		return queryBundle.getString(Query.APPLICATION_UPDATE);
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, Application entity) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getByIDQuery() {
		return queryBundle.getString(Query.APPLICATION_GET_BY_ID);
	}

	@Override
	public String getDeleteQuery() {
		return queryBundle.getString(Query.APPLICATION_DELETE);
	}

	@Override
	public String getAllQuery() {
		return queryBundle.getString(Query.APPLICATION_GET_ALL);
	}

	@Override
	String getByParamQuery(String name) {
		return queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID);
	}

	@Override
	public Application extractEntity(ResultSet rs, boolean eager) throws SQLException {
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

}

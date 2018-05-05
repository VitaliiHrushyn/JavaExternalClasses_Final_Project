package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.entities.application.Application;

public class ApplicationDAOImpl extends AbstractDAO<Application> implements ApplicationDAO {

	public ApplicationDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public String getCreateQuery() {
		return queryBundle.getString(Query.APPLICATION_INSERT);
	}

	@Override
	public void fillCreateStatement(PreparedStatement statement, Application entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUpdateQuery() {
		return queryBundle.getString(Query.APPLICATION_UPDATE);
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, Application entity) throws SQLException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application extractEntity(ResultSet rs, boolean eager) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	


}

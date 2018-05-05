package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialDAOImpl extends AbstractDAO<Testimonial> implements TestimonialDAO {

	public TestimonialDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillCreateStatement(PreparedStatement statement, Testimonial entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillUpdateStatement(PreparedStatement statement, Testimonial entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getByIDQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String getByParamQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonial extractEntity(ResultSet rs, boolean eager) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}

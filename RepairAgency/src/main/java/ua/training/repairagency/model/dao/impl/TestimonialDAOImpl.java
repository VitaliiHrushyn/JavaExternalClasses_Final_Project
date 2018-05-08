package ua.training.repairagency.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialDAOImpl extends AbstractDAO<Testimonial> implements TestimonialDAO {

	public TestimonialDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Testimonial create(Testimonial entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonial update(Testimonial entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonial getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Testimonial> getAll(boolean eager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Testimonial delete(Testimonial entity) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String getCreateQuery() {
//		return queryBundle.getString(Query.TESTIMONIAL_INSERT);
//	}
//
//	@Override
//	public void fillCreateStatement(PreparedStatement statement, Testimonial entity) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getUpdateQuery() {
//		return queryBundle.getString(Query.TESTIMONIAL_INSERT);
//	}
//
//	@Override
//	public void fillUpdateStatement(PreparedStatement statement, Testimonial entity) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getByIDQuery() {
//		return queryBundle.getString(Query.TESTIMONIAL_INSERT);
//	}
//
//	@Override
//	public String getDeleteQuery() {
//		return queryBundle.getString(Query.TESTIMONIAL_INSERT);
//	}
//
//	@Override
//	public String getAllQuery() {
//		return queryBundle.getString(Query.TESTIMONIAL_INSERT);
//	}
//
//	@Override
//	String getByParamQuery(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Testimonial extractEntity(ResultSet rs, boolean eager) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}

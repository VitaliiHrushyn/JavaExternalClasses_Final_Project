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
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.testimonial.TestimonialImpl;

public class TestimonialDAOImpl extends AbstractDAO<Testimonial> implements TestimonialDAO {

	public TestimonialDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Testimonial create(Testimonial testimonial) throws SQLException {
		try(PreparedStatement statement = 
				connection.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_INSERT), Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, testimonial.getText());
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
	public Testimonial update(Testimonial testimonial) throws SQLException {
		try(PreparedStatement statement = connection
				.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_UPDATE))) {
			statement.setString(1, testimonial.getText());
			statement.setInt(2, testimonial.getId());
			if (statement.executeUpdate() > 0) {
				return testimonial;
			}
		}
		return null;
	}

	@Override
	public Testimonial getById(int id) {
		try(PreparedStatement statement = connection
						.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_GET_BY_ID))) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return extractTestimonial(rs);	
			}
		} catch (SQLException e) {
			//TODO handle exception
			throw new RuntimeException(e);
		}	
		return null;
	}

	@Override
	public List<Testimonial> getAll(boolean eager) {
		List<Testimonial> testimonials = new ArrayList<>();
		try(PreparedStatement statement = connection
				.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_GET_ALL))) {
			ResultSet rs = statement.executeQuery();			
			while(rs.next()) {
				testimonials.add(extractTestimonial(rs));	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
		return testimonials;
	}

	@Override
	public Testimonial delete(Testimonial testimonial) {
		try(PreparedStatement statement = connection
				.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_DELETE))) {
			statement.setInt(1, testimonial.getId());
			if (statement.executeUpdate() > 0) {
				return testimonial;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return null;
	}
	
	private Testimonial extractTestimonial(ResultSet rs) throws SQLException {
		Testimonial testimonial = new TestimonialImpl();
		testimonial.setId(rs.getInt(columnBundle.getString(Column.TESTIMONIAL_ID)));
		testimonial.setText(rs.getString(columnBundle.getString(Column.TESTIMONIAL_TEXT)));
		testimonial.setCreateTime(rs.getDate(columnBundle.getString(Column.TESTIMONIAL_CREATE_TIME)));
		
		return testimonial;
	}

//	@Override
//	public Testimonial getByApplicationId(int applicationId) {
//		try(PreparedStatement statement = connection
//				.prepareStatement(queryBundle.getString(Query.TESTIMONIAL_GET_BY_APPLICATION_ID))) {
//			statement.setInt(1, applicationId);
//			ResultSet rs = statement.executeQuery();
//			if (rs.next()) {
//				return extractTestimonial(rs);	
//			}
//		} catch (SQLException e) {
//			//TODO handle exception
//			throw new RuntimeException(e);
//		}	
//		return null;
//	}

}

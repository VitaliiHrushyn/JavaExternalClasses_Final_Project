package ua.training.repairagency.model.dao.services.impl;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialServiceImpl implements TestimonialService {

	DAOFactory daoFactory = DAOFactory.getInstance();

	@Override
	public Testimonial getById(int testiminialId) {
		try(TestimonialDAO dao = daoFactory.createTestimonialDAO()){
			return dao.getById(testiminialId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	@Override
	public Testimonial insert(Testimonial testimonial) {
		try(TestimonialDAO dao = daoFactory.createTestimonialDAO()) {		
			return dao.create(testimonial);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(int testimonialId) {
		try(TestimonialDAO dao = daoFactory.createTestimonialDAO()) {		
			return dao.delete(testimonialId);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

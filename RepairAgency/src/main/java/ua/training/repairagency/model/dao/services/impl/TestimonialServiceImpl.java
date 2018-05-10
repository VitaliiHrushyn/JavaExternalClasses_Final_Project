package ua.training.repairagency.model.dao.services.impl;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.TestimonialDAO;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialServiceImpl implements TestimonialService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();

	@Override
	public Testimonial getById(int id) {
		try(TestimonialDAO dao = daoFactory.createTestimonialDAO()){
			return dao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Testimonial insert(Testimonial testimonial) {
		try(TestimonialDAO dao = daoFactory.createTestimonialDAO()) {				
			return dao.create(testimonial);				
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

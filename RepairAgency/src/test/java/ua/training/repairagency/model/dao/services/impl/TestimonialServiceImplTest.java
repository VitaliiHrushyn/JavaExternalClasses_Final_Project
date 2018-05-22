package ua.training.repairagency.model.dao.services.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialServiceImplTest {

	private TestimonialService service;
	private int testiminialId = 8;
	
	@Before
	public void setFactory() {
		this.service = ServiceFactory.getInstance().createTestimonialService();
	}
	
	@Test
	public void testGetById() {
		Testimonial testimonial = service.getById(testiminialId);
		assertNotNull(testimonial);
	}

}

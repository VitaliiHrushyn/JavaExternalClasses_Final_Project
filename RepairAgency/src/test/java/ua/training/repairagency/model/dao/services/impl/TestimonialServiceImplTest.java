package ua.training.repairagency.model.dao.services.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.entities.testimonial.Testimonial;

public class TestimonialServiceImplTest {

	private TestimonialService service;
	
	@Before
	public void setUp() {
		service = ServiceFactory.getInstance().createTestimonialService();
	}
	
	@Test
	public void testGetById() {
		int testiminialId = 8;
		Testimonial testimonial = service.getById(testiminialId);
		assertNotNull(testimonial);
	}

}

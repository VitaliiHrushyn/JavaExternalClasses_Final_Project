package ua.training.repairagency.model.dao.services.interfaces;

import ua.training.repairagency.model.entities.testimonial.Testimonial;

public interface TestimonialService {
	
	Testimonial getById(int testiminialId);
	
	Testimonial insert(Testimonial testimonial);

}

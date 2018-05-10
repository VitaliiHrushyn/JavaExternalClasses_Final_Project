package ua.training.repairagency.model.utils;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.testimonial.TestimonialImpl;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

public class TestimonialUtils {

	public static Testimonial createTestimonial(HttpServletRequest request) {
		Testimonial testimonial = new TestimonialImpl();
		testimonial.setText(request.getParameter(TESTIMONIAL_TEXT));		
		return testimonial;
	}
	
}

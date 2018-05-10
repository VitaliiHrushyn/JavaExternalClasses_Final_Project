package ua.training.repairagency.model.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.testimonial.TestimonialImpl;

public class TestimonialUtils {

	public static Testimonial createTestimonial(HttpServletRequest request) {
		Testimonial testimonial = new TestimonialImpl();
		testimonial.setText(request.getParameter(TEXT));
		
		return testimonial;
	}

}

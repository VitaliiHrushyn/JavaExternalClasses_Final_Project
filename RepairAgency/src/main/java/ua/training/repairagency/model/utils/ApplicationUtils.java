package ua.training.repairagency.model.utils;

import javax.servlet.http.HttpServletRequest;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.math.BigDecimal;

import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.entities.user.User;

public class ApplicationUtils {

	public static Application createNewApp(HttpServletRequest request) {
		Application application = new ApplicationImpl();
		application.setStatus(AppStatus.NEW);
		application.setDescription(request.getParameter(DESCRIPTION));
		application.setCustomer((User)(request.getSession().getAttribute(USER)));
		
		return application;
		
	}

	public static Application updateApplicationFeatures(Application application, HttpServletRequest request) {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		
		String status = request.getParameter(STATUS);
		String description = request.getParameter(DESCRIPTION);
		String managerComment = request.getParameter(COMMENT);
		String price = request.getParameter(PRICE);
		String workmanId = request.getParameter(WORKMAN_ID); 
		String testimonialId = request.getParameter(TESTIMONIAL_ID);		
		
		if (notEmpty(status)) {
			application.setStatus(AppStatus.valueOf(status));
		}
		if (notEmpty(description)) {
			application.setDescription(description);
		}
		if (notEmpty(managerComment)) {
			application.setManagerComment(managerComment);
		}
		if (notEmpty(price)) {
			application.setPrice(BigDecimal.valueOf(Long.valueOf(price)));
		}
		if (notEmpty(workmanId)) {
			application.setWorkman(factory.createUserService().getById(Integer.valueOf(workmanId)));
		}
		if (notEmpty(testimonialId)) {
			application.setTestimonial(factory.createTestimonialService().getById(Integer.valueOf(testimonialId)));
		}
				
		return application;
	}

	private static boolean notEmpty(String value) {
		return value != null && !value.isEmpty();
	}

}

package ua.training.repairagency.model.utils;

import javax.servlet.http.HttpServletRequest;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.math.BigDecimal;

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
		application.setStatus(AppStatus.valueOf(request.getParameter(STATUS)));
		application.setDescription(request.getParameter(DESCRIPTION));
		application.setManagerComment(request.getParameter(COMMENT));
		if (request.getParameter(PRICE) != null && !request.getParameter(PRICE).isEmpty()) {
			application.setPrice(BigDecimal.valueOf(Long.valueOf(request.getParameter(PRICE))));
		}
//		application.setWorkman(request.getParameter(WORKMAN));
//		application.setTestimonial(request.getParameter(TESTIMONIAL));
		
		return application;
	}

}

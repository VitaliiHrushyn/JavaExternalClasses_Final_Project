package ua.training.repairagency.model.utils;

import static ua.training.repairagency.model.utils.DAOutils.paramNotEmpty;
import javax.servlet.http.HttpServletRequest;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.math.BigDecimal;

import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.entities.testimonial.Testimonial;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;

public class ApplicationUtils {

	public static Application createNewApp(HttpServletRequest request) {
		Application application = new ApplicationImpl();
		application.setStatus(AppStatus.NEW);
		application.setDescription(request.getParameter(DESCRIPTION));
		application.setCustomer((User)(request.getSession().getAttribute(USER)));
		
		return application;
		
	}

	public static Application updateApplicationFeatures(Application application,
			HttpServletRequest request) throws OutOfDateDataException {
		
		/*
		 *  Prevention of insertion out of dated data
		 */
		if (!application.getLastUpdateTime().toString().equals(request.getParameter(LAST_UPDATE))) {
			throw new OutOfDateDataException(application.toString());
		}
		
		ServiceFactory factory = ServiceFactory.getInstance();
		
		String status = request.getParameter(STATUS);
		String description = request.getParameter(DESCRIPTION);
		String managerComment = request.getParameter(COMMENT);
		String price = request.getParameter(PRICE);
		String workmanId = request.getParameter(WORKMAN_ID); 
		String testimonialId = request.getParameter(TESTIMONIAL_ID);
		String testimonialText = request.getParameter(TESTIMONIAL_TEXT);
		
		if (paramNotEmpty(testimonialText)) {
			Testimonial testimonial = factory
						.createTestimonialService()
						.insert(TestimonialUtils.createTestimonial(request));
			
			testimonialId = String.valueOf(testimonial.getId());
		}
		
		if (paramNotEmpty(status)) {
			application.setStatus(AppStatus.valueOf(status));
		}
		if (paramNotEmpty(description)) {
			application.setDescription(description);
		}
		if (paramNotEmpty(managerComment)) {
			application.setManagerComment(managerComment);
		}
		if (paramNotEmpty(price)) {
			application.setPrice(new BigDecimal((price)));
		}
		if (paramNotEmpty(workmanId)) {
			application.setWorkman(factory.createUserService().getById(Integer.valueOf(workmanId)));
		}
		if (paramNotEmpty(testimonialId)) {
			application.setTestimonial(factory.createTestimonialService().getById(Integer.valueOf(testimonialId)));
		}
				
		return application;
	}

}

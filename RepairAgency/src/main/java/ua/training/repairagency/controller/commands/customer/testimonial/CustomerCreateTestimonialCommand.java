package ua.training.repairagency.controller.commands.customer.testimonial;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.utils.TestimonialUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerCreateTestimonialCommand extends AbstractCommand {	
	
	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<>();
		errorMessages = new ArrayList<>();
		
		if (!isRequestEmpty(request)) {
			try {
				serviceFactory
				.createTestimonialService()
				.insert(TestimonialUtils.createTestimonial(request)); 
				
				infoMessages.add(messageBundle.getString(Message.TESTIMONIAL_CREATE_SUCCESS));
				page = URL.CUSTOMER_APPLICATION_INDEX_PAGE;
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(messageBundle.getString(Message.TESTIMONIAL_CREATE_FAIL));
				page = URL.CUSTOMER_TESTIMONIAL_CREATE_PAGE;
			} 
		} else {
			page = URL.CUSTOMER_TESTIMONIAL_CREATE_PAGE;
		}		
		
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);		
		return page;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(TEXT) == null;
	}
}

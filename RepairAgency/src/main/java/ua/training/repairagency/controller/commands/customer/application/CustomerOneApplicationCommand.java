package ua.training.repairagency.controller.commands.customer.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerOneApplicationCommand extends AbstractCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
					
		if (!isRequestEmpty(request)) {
		
			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			
			request.setAttribute(APPLICATION, application);	
			page = URL.CUSTOMER_APPLICATION_ONE_PAGE;
		} else {
			page = URL.CUSTOMER_APPLICATION_ALL_COMMAND;
		}
		
		return page;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(ID) == null;
	}
	
}
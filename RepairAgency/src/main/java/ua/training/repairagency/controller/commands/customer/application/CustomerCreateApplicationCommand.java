package ua.training.repairagency.controller.commands.customer.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.ApplicationUtil;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerCreateApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		messages = new ArrayList<>();
		
		if (!isRequestEmpty(request)) {
			try {
				serviceFactory.createApplicationService().insert(ApplicationUtil.create(request)); 
				messages.add(Message.APPLICATION_CREATE_SUCCESS);
				path = URL.CUSTOMER_APPLICATION_INDEX_PAGE;
			} catch (Exception e) {
				e.printStackTrace();
				messages.add(Message.APPLICATION_CREATE_FAIL);
				path = URL.CUSTOMER_APPLICATION_CREATE_PAGE;
			} 
		} else {
			path = URL.CUSTOMER_APPLICATION_CREATE_PAGE;
		}
		
		
		request.setAttribute(MESSAGES, messages);
		return path;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(DESCRIPTION) == null;
	}
	
}
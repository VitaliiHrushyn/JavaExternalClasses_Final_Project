package ua.training.repairagency.controller.commands.customer.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.utils.ApplicationUtil;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerCreateApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<>();
		errorMessages = new ArrayList<>();
		
		if (!isRequestEmpty(request)) {
			try {
				serviceFactory
				.createApplicationService()
				.insert(ApplicationUtil.createNewApp(request)); 
				
				infoMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_SUCCESS));
				page = URL.CUSTOMER_APPLICATION_INDEX_PAGE;
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_FAIL));
				page = URL.CUSTOMER_APPLICATION_CREATE_PAGE;
			} 
		} else {
			page = URL.CUSTOMER_APPLICATION_CREATE_PAGE;
		}		
		
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);		
		return page;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(DESCRIPTION) == null;
	}
	
}
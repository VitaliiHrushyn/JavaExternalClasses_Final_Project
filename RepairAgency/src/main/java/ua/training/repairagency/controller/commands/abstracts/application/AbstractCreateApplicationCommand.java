package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.utils.ApplicationUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;

public abstract class AbstractCreateApplicationCommand extends AbstractCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		infoMessages = new ArrayList<>();
		errorMessages = new ArrayList<>();
		
		if (!isRequestEmpty(request)) {
			try {
				serviceFactory
				.createApplicationService()
				.insert(ApplicationUtils.createNewApp(request)); 
				
				infoMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_SUCCESS));
				page = getApplicationIndexPage();
			} catch (Exception e) {
				e.printStackTrace();
				errorMessages.add(messageBundle.getString(Message.APPLICATION_CREATE_FAIL));
				page = getApplicationCreatePage();
			} 
		} else {
			page = getApplicationCreatePage();
		}		
		
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);		
		return page;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(DESCRIPTION) == null;
	}
	
	protected abstract String getApplicationIndexPage();
	protected abstract String getApplicationCreatePage();
	
}
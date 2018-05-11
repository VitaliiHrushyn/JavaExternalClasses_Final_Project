package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;

public abstract class AbstractFinishApplicationCommand extends AbstractCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
					
		if (!isRequestEmpty(request)) {
		
			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			
			request.setAttribute(APPLICATION, application);	
			page = getApplicationFinishPage();
		} else {
			page = getApplicationAllCommand();
		}
		
		return page;
	}

	private boolean isRequestEmpty(HttpServletRequest request) {
		return request.getParameter(ID) == null;
	}
	
	protected abstract String getApplicationFinishPage();
	protected abstract String getApplicationAllCommand();
}
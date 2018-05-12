package ua.training.repairagency.controller.commands.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.utils.CommandUtils;

public abstract class AbstractShowOneApplicationCommand extends AbstractCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
					
		if (CommandUtils.isRequestContains(request, ID)) {
		
			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			
			request.setAttribute(APPLICATION, application);	
			page = getApplicationOnePage();
		} else {
			page = getApplicationAllCommand();
		}
		
		return page;
	}
	
	protected abstract String getApplicationOnePage();
	protected abstract String getApplicationAllCommand();
	
}
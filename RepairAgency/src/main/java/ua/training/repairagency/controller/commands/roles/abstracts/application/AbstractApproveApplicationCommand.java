package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;

public abstract class AbstractApproveApplicationCommand extends AbstractCommand {
	
	public AbstractApproveApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		errorMessages = new  ArrayList<String>();
		
		if (!CommandUtils.isRequestContainsParam(request, ID)) {
			return getApplicationCommand();
		}
		
		Application application = serviceFactory
					 			.createApplicationService()
					 			.getById(Integer.valueOf(request.getParameter(ID)));
			 
		setSpecifiedAtribute(request); 
		
		request.setAttribute(APPLICATION, application);		
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return getApplicationApprovePage();
	}

	protected abstract String getApplicationApprovePage();
	protected abstract String getApplicationCommand();	
	protected abstract void setSpecifiedAtribute(HttpServletRequest request);
}
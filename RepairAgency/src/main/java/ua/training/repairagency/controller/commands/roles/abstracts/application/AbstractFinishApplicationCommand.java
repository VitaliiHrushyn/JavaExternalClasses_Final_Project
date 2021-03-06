package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;

public abstract class AbstractFinishApplicationCommand extends AbstractCommand {
	
	public AbstractFinishApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
							
		if (!CommandUtils.isRequestContainsParam(request, ID)) {
			return getApplicationCommand();
		}
		
			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			
			request.setAttribute(APPLICATION, application);	
			return getApplicationFinishPage();
	}

	protected abstract String getApplicationFinishPage();
	protected abstract String getApplicationCommand();
}
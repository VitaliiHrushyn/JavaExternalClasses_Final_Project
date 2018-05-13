package ua.training.repairagency.controller.commands.roles.abstracts.application;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;

public abstract class AbstractShowOneApplicationCommand extends AbstractCommand {
	
	public AbstractShowOneApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
					
		if (CommandUtils.isRequestContainsParam(request, ID)) {
		
			 Application application = serviceFactory
					 					.createApplicationService()
					 					.getById(Integer.valueOf(request.getParameter(ID)));
			 
			 List<User> workmen = serviceFactory
					 				.createUserService()
					 				.getAllByRole(UserRole.WORKMAN);
			
			request.setAttribute(APPLICATION, application);
			request.setAttribute(WORKMEN, workmen);
			page = getApplicationOnePage();
		} else {
			page = getApplicationCommand();
		}
		
		return page;
	}
	
	protected abstract String getApplicationOnePage();
	protected abstract String getApplicationCommand();
	
}
package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractApproveApplicationCommand;

public class ManagerApproveApplicationCommand extends AbstractApproveApplicationCommand {

	private static String commandPath = URL.MANAGER_APPLICATIONS_APPROVE_PATH;

	public ManagerApproveApplicationCommand(Map<String, Command> commands) {
		super(commandPath , commands);
	}

	@Override
	protected String getApplicationApprovePage() {
		return URL.MANAGER_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.MANAGER_APPLICATION_NEW_COMMAND;
	}	

	@Override
	protected void setSpecifiedAtribute(HttpServletRequest request) {
		List<User> workmen = serviceFactory
				.createUserService()
				.getAllByRole(UserRole.WORKMAN);
		
		request.setAttribute(WORKMEN, workmen);
	}

}
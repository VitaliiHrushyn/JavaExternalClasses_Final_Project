package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractApproveApplicationCommand;

public class ManagerApproveApplicationCommand extends AbstractApproveApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_APPROVE_PATH;

	public ManagerApproveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationApprovePage() {
		return URL.MANAGER_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
		
}
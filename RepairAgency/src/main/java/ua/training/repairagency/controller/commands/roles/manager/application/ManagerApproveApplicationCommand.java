package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApproveApplicationCommand;

public class ManagerApproveApplicationCommand extends AbstractApproveApplicationCommand {

	@Override
	protected String getApplicationApprovePage() {
		return URL.MANAGER_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
		
}
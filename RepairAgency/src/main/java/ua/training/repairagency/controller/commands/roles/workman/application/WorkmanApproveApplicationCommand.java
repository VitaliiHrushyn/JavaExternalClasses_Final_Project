package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApproveApplicationCommand;

public class WorkmanApproveApplicationCommand extends AbstractApproveApplicationCommand {

	@Override
	protected String getApplicationApprovePage() {
		return URL.WORKMAN_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.WORKMAN_APPLICATION_ALL_COMMAND;
	}
		
}
package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractApproveApplicationCommand;

public class WorkmanApproveApplicationCommand extends AbstractApproveApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_APPROVE_PATH;

	public WorkmanApproveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationApprovePage() {
		return URL.WORKMAN_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.WORKMAN_APPLICATION_INDEX_COMMAND;
	}
		
}
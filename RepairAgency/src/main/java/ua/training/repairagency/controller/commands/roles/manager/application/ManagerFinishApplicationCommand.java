package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractFinishApplicationCommand;

public class ManagerFinishApplicationCommand extends AbstractFinishApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_FINISH_PATH;

	public ManagerFinishApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationFinishPage() {
		return URL.MANAGER_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
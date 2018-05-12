package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractEditApplicationCommand;

public class ManagerEditApplicationCommand extends AbstractEditApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_EDIT_PATH;

	public ManagerEditApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
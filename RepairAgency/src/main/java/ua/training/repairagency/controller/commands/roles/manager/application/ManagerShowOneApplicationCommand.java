package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowOneApplicationCommand;

public class ManagerShowOneApplicationCommand extends AbstractShowOneApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_ONE_PATH;

	public ManagerShowOneApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationOnePage() {
		return URL.MANAGER_APPLICATION_ONE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
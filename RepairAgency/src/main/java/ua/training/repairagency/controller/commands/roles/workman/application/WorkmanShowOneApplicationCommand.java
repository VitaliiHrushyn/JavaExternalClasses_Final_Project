package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowOneApplicationCommand;

public class WorkmanShowOneApplicationCommand extends AbstractShowOneApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_ONE_PATH;

	public WorkmanShowOneApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationOnePage() {
		return URL.COMMON_APPLICATION_ONE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.WORKMAN_APPLICATION_INDEX_COMMAND;
	}
	
}
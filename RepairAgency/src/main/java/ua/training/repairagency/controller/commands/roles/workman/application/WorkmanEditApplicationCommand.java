package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractEditApplicationCommand;

public class WorkmanEditApplicationCommand extends AbstractEditApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_EDIT_PATH;

	public WorkmanEditApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.WORKMAN_APPLICATION_ALL_COMMAND;
	}
	
}
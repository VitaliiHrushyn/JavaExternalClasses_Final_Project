package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractFinishApplicationCommand;

public class WorkmanFinishApplicationCommand extends AbstractFinishApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_FINISH_PATH;

	public WorkmanFinishApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationFinishPage() {
		return URL.WORKMAN_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.WORKMAN_APPLICATION_ALL_COMMAND;
	}
	
}
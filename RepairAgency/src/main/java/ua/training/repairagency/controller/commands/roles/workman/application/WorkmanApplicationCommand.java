package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractApplicationCommand;

public class WorkmanApplicationCommand extends AbstractApplicationCommand {

	private static String path = URL.WORKMAN_APPLICATIONS_PATH;

	public WorkmanApplicationCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	protected String getApplicationIndexPage() {
		return URL.WORKMAN_APPLICATION_INDEX_PAGE;
	}	

}

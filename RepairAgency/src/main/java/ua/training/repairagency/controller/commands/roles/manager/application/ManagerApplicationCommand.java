package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractApplicationCommand;

public class ManagerApplicationCommand extends AbstractApplicationCommand {

	private static String path = URL.MANAGER_APPLICATIONS_PATH;

	public ManagerApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationIndexPage() {
		return URL.MANAGER_APPLICATION_INDEX_PAGE;
	}	

}

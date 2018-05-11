package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractEditApplicationCommand;

public class ManagerEditApplicationCommand extends AbstractEditApplicationCommand {

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractFinishApplicationCommand;

public class ManagerFinishApplicationCommand extends AbstractFinishApplicationCommand {

	@Override
	protected String getApplicationFinishPage() {
		return URL.MANAGER_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
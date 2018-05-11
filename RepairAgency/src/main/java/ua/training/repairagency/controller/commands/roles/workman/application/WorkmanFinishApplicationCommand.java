package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractFinishApplicationCommand;

public class WorkmanFinishApplicationCommand extends AbstractFinishApplicationCommand {

	@Override
	protected String getApplicationFinishPage() {
		return URL.WORKMAN_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.WORKMAN_APPLICATION_ALL_COMMAND;
	}
	
}
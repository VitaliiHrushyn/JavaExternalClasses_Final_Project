package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractEditApplicationCommand;

public class WorkmanEditApplicationCommand extends AbstractEditApplicationCommand {

	@Override
	protected String getApplicationAllCommand() {
		return URL.WORKMAN_APPLICATION_ALL_COMMAND;
	}
	
}
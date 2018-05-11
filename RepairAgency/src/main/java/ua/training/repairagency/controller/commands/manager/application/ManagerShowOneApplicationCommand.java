package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowOneApplicationCommand;

public class ManagerShowOneApplicationCommand extends AbstractShowOneApplicationCommand {

	@Override
	protected String getApplicationOnePage() {
		return URL.MANAGER_APPLICATION_ONE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.MANAGER_APPLICATION_ALL_COMMAND;
	}
	
}
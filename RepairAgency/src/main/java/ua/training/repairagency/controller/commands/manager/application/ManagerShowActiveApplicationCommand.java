package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowActiveApplicationCommand;

public class ManagerShowActiveApplicationCommand extends AbstractShowActiveApplicationCommand {

	@Override
	protected String getApplicationShowPage() {
		return URL.MANAGER_APPLICATION_SHOW_PAGE; 
	}

}
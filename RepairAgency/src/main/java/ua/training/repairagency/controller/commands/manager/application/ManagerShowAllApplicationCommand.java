package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowAllApplicationCommand;

public class ManagerShowAllApplicationCommand extends AbstractShowAllApplicationCommand {

	@Override
	protected String getApplicationShowPage() {
		return URL.MANAGER_APPLICATION_SHOW_PAGE; 
	}
	
}
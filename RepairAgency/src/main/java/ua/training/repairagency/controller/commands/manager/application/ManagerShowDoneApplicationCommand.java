package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowDoneApplicationCommand;

public class ManagerShowDoneApplicationCommand extends AbstractShowDoneApplicationCommand {

	@Override
	protected String getApplicationDonePage() {
		return URL.MANAGER_APPLICATION_DONE_PAGE; 
	}
	
}
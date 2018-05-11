package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowReceivedApplicationCommand;

public class ManagerShowReceivedApplicationCommand extends AbstractShowReceivedApplicationCommand {

	@Override
	protected String getApplicationReceivedPage() {
		return URL.MANAGER_APPLICATION_RECEIVED_PAGE; 
	}
	
}
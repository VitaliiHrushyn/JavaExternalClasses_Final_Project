package ua.training.repairagency.controller.commands.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApplicationCommand;

public class ManagerApplicationCommand extends AbstractApplicationCommand {

	@Override
	protected String getApplicationIndexPage() {
		return URL.MANAGER_APPLICATION_INDEX_PAGE;
	}	

}

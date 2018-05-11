package ua.training.repairagency.controller.commands.roles.workman.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApplicationCommand;

public class WorkmanApplicationCommand extends AbstractApplicationCommand {

	@Override
	protected String getApplicationIndexPage() {
		return URL.WORKMAN_APPLICATION_INDEX_PAGE;
	}	

}

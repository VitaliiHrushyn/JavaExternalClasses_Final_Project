package ua.training.repairagency.controller.commands.roles.manager.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractCreateApplicationCommand;
@Deprecated
public class ManagerCreateApplicationCommand extends AbstractCreateApplicationCommand {

	@Override
	protected String getApplicationIndexPage() {
		return URL.MANAGER_APPLICATION_INDEX_PAGE;
	}

	@Override
	protected String getApplicationCreatePage() {
		return URL.MANAGER_APPLICATION_CREATE_PAGE;
	}

}
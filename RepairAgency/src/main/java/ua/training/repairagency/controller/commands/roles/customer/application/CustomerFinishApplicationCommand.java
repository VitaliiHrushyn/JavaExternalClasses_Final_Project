package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractFinishApplicationCommand;

public class CustomerFinishApplicationCommand extends AbstractFinishApplicationCommand {

	@Override
	protected String getApplicationFinishPage() {
		return URL.CUSTOMER_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.CUSTOMER_APPLICATION_ALL_COMMAND;
	}
	
}
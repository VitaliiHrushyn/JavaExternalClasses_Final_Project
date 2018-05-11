package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractEditApplicationCommand;

public class CustomerEditApplicationCommand extends AbstractEditApplicationCommand {

	@Override
	protected String getApplicationAllCommand() {
		return URL.CUSTOMER_APPLICATION_ALL_COMMAND;
	}
	
}
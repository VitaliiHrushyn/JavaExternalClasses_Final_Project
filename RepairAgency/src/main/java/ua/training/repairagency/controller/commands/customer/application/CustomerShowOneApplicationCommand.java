package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowOneApplicationCommand;

public class CustomerShowOneApplicationCommand extends AbstractShowOneApplicationCommand {

	@Override
	protected String getApplicationOnePage() {
		return URL.CUSTOMER_APPLICATION_ONE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.CUSTOMER_APPLICATION_ALL_COMMAND;
	}
	
}
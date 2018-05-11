package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowActiveApplicationCommand;

public class CustomerShowActiveApplicationCommand extends AbstractShowActiveApplicationCommand {

	@Override
	protected String getApplicationShowPage() {
		return URL.CUSTOMER_APPLICATION_SHOW_PAGE; 
	}

}
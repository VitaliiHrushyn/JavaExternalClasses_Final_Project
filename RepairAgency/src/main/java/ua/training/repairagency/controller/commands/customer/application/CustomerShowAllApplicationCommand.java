package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowAllApplicationCommand;

public class CustomerShowAllApplicationCommand extends AbstractShowAllApplicationCommand {

	@Override
	protected String getApplicationShowPage() {
		return URL.CUSTOMER_APPLICATION_SHOW_PAGE; 
	}
	
}
package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowDoneApplicationCommand;

public class CustomerShowDoneApplicationCommand extends AbstractShowDoneApplicationCommand {

	@Override
	protected String getApplicationDonePage() {
		return URL.CUSTOMER_APPLICATION_DONE_PAGE; 
	}
	
}
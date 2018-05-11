package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractShowReceivedApplicationCommand;

public class CustomerShowReceivedApplicationCommand extends AbstractShowReceivedApplicationCommand {

	@Override
	protected String getApplicationReceivedPage() {
		return URL.CUSTOMER_APPLICATION_RECEIVED_PAGE; 
	}
	
}
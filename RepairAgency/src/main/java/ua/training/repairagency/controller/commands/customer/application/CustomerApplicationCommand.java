package ua.training.repairagency.controller.commands.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApplicationCommand;

public class CustomerApplicationCommand extends AbstractApplicationCommand {

	@Override
	protected String getApplicationIndexPage() {
		return URL.CUSTOMER_APPLICATION_INDEX_PAGE;
	}	

}

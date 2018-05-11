package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractCreateApplicationCommand;

public class CustomerCreateApplicationCommand extends AbstractCreateApplicationCommand {

	@Override
	protected String getApplicationIndexPage() {
		return URL.CUSTOMER_APPLICATION_INDEX_PAGE;
	}

	@Override
	protected String getApplicationCreatePage() {
		return URL.CUSTOMER_APPLICATION_CREATE_PAGE;
	}

}
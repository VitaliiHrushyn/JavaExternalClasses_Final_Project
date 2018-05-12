package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractCreateApplicationCommand;

public class CustomerCreateApplicationCommand extends AbstractCreateApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_CREATE_PATH;

	public CustomerCreateApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationIndexPage() {
		return URL.CUSTOMER_APPLICATION_INDEX_PAGE;
	}

	@Override
	protected String getApplicationCreatePage() {
		return URL.CUSTOMER_APPLICATION_CREATE_PAGE;
	}

}
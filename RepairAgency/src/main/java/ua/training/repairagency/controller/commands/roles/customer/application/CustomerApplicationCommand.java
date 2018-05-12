package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApplicationCommand;

public class CustomerApplicationCommand extends AbstractApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_PATH;

	public CustomerApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationIndexPage() {
		return URL.CUSTOMER_APPLICATION_INDEX_PAGE;
	}	

}

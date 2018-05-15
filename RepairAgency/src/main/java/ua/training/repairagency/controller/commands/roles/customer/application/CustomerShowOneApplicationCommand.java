package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractShowOneApplicationCommand;

public class CustomerShowOneApplicationCommand extends AbstractShowOneApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_ONE_PATH;

	public CustomerShowOneApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationOnePage() {
		return URL.COMMON_APPLICATION_ONE_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.CUSTOMER_APPLICATION_INDEX_COMMAND;
	}
	
}
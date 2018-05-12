package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractFinishApplicationCommand;

public class CustomerFinishApplicationCommand extends AbstractFinishApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_FINISH_PATH;

	public CustomerFinishApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationFinishPage() {
		return URL.CUSTOMER_APPLICATION_FINISH_PAGE;
	}

	@Override
	protected String getApplicationCommand() {
		return URL.CUSTOMER_APPLICATION_INDEX_COMMAND;
	}
	
}
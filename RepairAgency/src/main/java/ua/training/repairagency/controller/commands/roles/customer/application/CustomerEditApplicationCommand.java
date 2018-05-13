package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.application.AbstractEditApplicationCommand;

public class CustomerEditApplicationCommand extends AbstractEditApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_EDIT_PATH;

	public CustomerEditApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationCommand() {
		return URL.CUSTOMER_APPLICATION_INDEX_COMMAND;
	}
	
	@Override
	protected boolean checkParameters(HttpServletRequest request, List<String> errorMessages) {
		/* no specified checking in this class */	
		return true;
	}
			
}
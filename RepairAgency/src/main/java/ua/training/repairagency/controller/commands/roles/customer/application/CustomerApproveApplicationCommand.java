package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApproveApplicationCommand;

public class CustomerApproveApplicationCommand extends AbstractApproveApplicationCommand {

	private static String path = URL.CUSTOMER_APPLICATIONS_APPROVE_PATH;

	public CustomerApproveApplicationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationApprovePage() {
		return URL.CUSTOMER_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.CUSTOMER_APPLICATION_ALL_COMMAND;
	}
		
}
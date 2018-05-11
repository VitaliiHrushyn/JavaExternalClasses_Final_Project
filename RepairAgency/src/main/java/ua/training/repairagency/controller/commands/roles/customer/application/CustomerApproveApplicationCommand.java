package ua.training.repairagency.controller.commands.roles.customer.application;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApproveApplicationCommand;

public class CustomerApproveApplicationCommand extends AbstractApproveApplicationCommand {

	@Override
	protected String getApplicationApprovePage() {
		return URL.CUSTOMER_APPLICATION_APPROVE_PAGE;
	}

	@Override
	protected String getApplicationAllCommand() {
		return URL.CUSTOMER_APPLICATION_ALL_COMMAND;
	}
		
}
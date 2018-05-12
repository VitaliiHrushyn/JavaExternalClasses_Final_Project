package ua.training.repairagency.controller.commands.roles.customer.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractEditprofileCommand;

public class CustomerEditprofileCommand extends AbstractEditprofileCommand {

	private static String path = URL.CUSTOMER_ROFILE_EDIT_PATH;

	public CustomerEditprofileCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getEditprofilePage() {
		return URL.CUSTOMER_EDITPROFILE_PAGE;
	}		
	
}

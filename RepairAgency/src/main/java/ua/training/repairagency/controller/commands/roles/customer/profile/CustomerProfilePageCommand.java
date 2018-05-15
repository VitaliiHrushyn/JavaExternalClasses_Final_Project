package ua.training.repairagency.controller.commands.roles.customer.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractProfilePageCommand;

public class CustomerProfilePageCommand extends AbstractProfilePageCommand {

	private static String path = URL.CUSTOMER_PROFILE_PATH;

	public CustomerProfilePageCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getProfilePage() {
		return URL.COMMON_PROFILE_PAGE;
	}
	
}

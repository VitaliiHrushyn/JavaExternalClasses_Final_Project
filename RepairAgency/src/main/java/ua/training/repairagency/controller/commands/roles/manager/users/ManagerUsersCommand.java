package ua.training.repairagency.controller.commands.roles.manager.users;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.abstracts.application.AbstractApplicationCommand;

public class ManagerUsersCommand extends AbstractApplicationCommand {

	private static String path = URL.MANAGER_USERS_PATH;

	public ManagerUsersCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getApplicationIndexPage() {
		return URL.MANAGER_USERS_INDEX_PAGE;
	}	

}

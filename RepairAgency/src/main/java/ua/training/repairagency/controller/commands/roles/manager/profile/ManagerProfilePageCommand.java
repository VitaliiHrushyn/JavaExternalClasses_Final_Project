package ua.training.repairagency.controller.commands.roles.manager.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractProfilePageCommand;

public class ManagerProfilePageCommand extends AbstractProfilePageCommand {

	private static String path = URL.MANAGER_PROFILE_PATH;

	public ManagerProfilePageCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getProfilePage() {
		return URL.MANAGER_PROFILE_PAGE;
	}
	
}

package ua.training.repairagency.controller.commands.roles.workman.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractProfilePageCommand;

public class WorkmanProfilePageCommand extends AbstractProfilePageCommand {

	private static String path = URL.WORKMAN_PROFILE_PATH;

	public WorkmanProfilePageCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getProfilePage() {
		return URL.COMMON_PROFILE_PAGE;
	}
	
}

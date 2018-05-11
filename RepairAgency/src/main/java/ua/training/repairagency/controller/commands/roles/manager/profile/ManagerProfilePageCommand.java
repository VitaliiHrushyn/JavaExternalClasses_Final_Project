package ua.training.repairagency.controller.commands.roles.manager.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractProfilePageCommand;

public class ManagerProfilePageCommand extends AbstractProfilePageCommand {

	@Override
	protected String getProfilePage() {
		return URL.MANAGER_PROFILE_PAGE;
	}
	
}

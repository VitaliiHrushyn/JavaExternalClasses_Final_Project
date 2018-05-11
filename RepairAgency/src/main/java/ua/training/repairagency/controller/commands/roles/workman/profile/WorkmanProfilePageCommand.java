package ua.training.repairagency.controller.commands.roles.workman.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractProfilePageCommand;

public class WorkmanProfilePageCommand extends AbstractProfilePageCommand {

	@Override
	protected String getProfilePage() {
		return URL.WORKMAN_PROFILE_PAGE;
	}
	
}

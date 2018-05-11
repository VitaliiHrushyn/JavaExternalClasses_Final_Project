package ua.training.repairagency.controller.commands.roles.manager.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractEditprofileCommand;

public class ManagerEditprofileCommand extends AbstractEditprofileCommand {

	@Override
	protected String getEditprofilePage() {
		return URL.MANAGER_EDITPROFILE_PAGE;
	}		
	
}

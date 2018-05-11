package ua.training.repairagency.controller.commands.roles.workman.profile;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.abstracts.profile.AbstractEditprofileCommand;

public class WorkmanEditprofileCommand extends AbstractEditprofileCommand {

	@Override
	protected String getEditprofilePage() {
		return URL.WORKMAN_EDITPROFILE_PAGE;
	}		
	
}

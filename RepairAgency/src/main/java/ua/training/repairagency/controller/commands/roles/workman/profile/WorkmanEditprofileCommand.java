package ua.training.repairagency.controller.commands.roles.workman.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractEditprofileCommand;

public class WorkmanEditprofileCommand extends AbstractEditprofileCommand {

	private static String path = URL.WORKMAN_ROFILE_EDIT_PATH;

	public WorkmanEditprofileCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getEditprofilePage() {
		return URL.WORKMAN_EDITPROFILE_PAGE;
	}		
	
}

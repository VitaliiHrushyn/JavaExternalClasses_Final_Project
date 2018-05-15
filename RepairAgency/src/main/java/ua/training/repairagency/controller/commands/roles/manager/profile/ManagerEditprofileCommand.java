package ua.training.repairagency.controller.commands.roles.manager.profile;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.roles.abstracts.profile.AbstractEditprofileCommand;

public class ManagerEditprofileCommand extends AbstractEditprofileCommand {

	private static String path = URL.MANAGER_ROFILE_EDIT_PATH;

	public ManagerEditprofileCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	protected String getEditprofilePage() {
		return URL.COMMON_EDITPROFILE_PAGE;
	}		
	
}

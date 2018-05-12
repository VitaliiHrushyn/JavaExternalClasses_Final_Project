package ua.training.repairagency.controller.commands.roles.abstracts.profile;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractProfilePageCommand extends AbstractCommand {

	public AbstractProfilePageCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		return getProfilePage();
	}
	
	protected abstract String getProfilePage();

}

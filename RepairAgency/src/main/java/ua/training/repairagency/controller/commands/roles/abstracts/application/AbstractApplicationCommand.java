package ua.training.repairagency.controller.commands.roles.abstracts.application;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractApplicationCommand extends AbstractCommand {

	public AbstractApplicationCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
				
		return getApplicationIndexPage();
	}
	
	protected abstract String getApplicationIndexPage();

}

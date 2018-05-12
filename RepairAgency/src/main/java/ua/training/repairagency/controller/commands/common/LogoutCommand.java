package ua.training.repairagency.controller.commands.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.AccessUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class LogoutCommand extends AbstractCommand {
	
	private static String path = URL.LOGOUT;

	public LogoutCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {			
		AccessUtils.logoutUser(request.getSession());
		return URL.REDIRECT_INDEX_COMMAND;
	}

}

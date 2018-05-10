package ua.training.repairagency.controller.commands.common;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.AccessUtils;
import ua.training.repairagency.controller.commands.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {			
		AccessUtils.logoutUser(request.getSession());
		return URL.REDIRECT_INDEX_COMMAND;
	}

}

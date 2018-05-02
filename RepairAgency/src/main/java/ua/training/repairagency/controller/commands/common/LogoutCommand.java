package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.REDIRECT_LOGIN_COMMAND;
import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.USER;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {		
		request.getSession().setAttribute(USER, null);
		return REDIRECT_LOGIN_COMMAND;
	}

}

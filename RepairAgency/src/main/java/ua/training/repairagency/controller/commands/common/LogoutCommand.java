package ua.training.repairagency.controller.commands.common;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.AttributeOrParam;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {		
		request.getSession().setAttribute(AttributeOrParam.USER, null);
		return URL.REDIRECT_LOGIN_COMMAND;
	}

}

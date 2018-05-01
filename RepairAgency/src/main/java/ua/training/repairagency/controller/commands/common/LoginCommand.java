package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;
import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.*;
import static ua.training.repairagency.controller.constants.MessageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.GetUserByLoginService;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);		
		HttpSession session = request.getSession();
		
		String message = null;
		String path = LOGIN_PAGE;
		
		//TODO : use Optional to avoid checking for a null
		
		if (checkLoginPassword(login, password)) {				
			User user = new GetUserByLoginService().execute(login);			
			
			if (validateUserPassword(password, user)) {
				path = CommandUtils.getPathFromRole(user.getRole());
				session.setAttribute(USER, user);
			} else {
				message = LOGIN_FAIL_MESSAGE;
			}
			
		} else {
			message = LOGIN_EMPTY_MESSAGE;
		}	
		request.setAttribute(LOGIN_MESSAGE_PARAM, message);		
		return path;
	}

	private boolean checkLoginPassword(String login, String password) {
		return (login != null && password != null) && (!login.isEmpty() && !password.isEmpty());
	}
	
	private boolean validateUserPassword(String password, User user) {
		return user != null && user.getPassword().equals(password);
	}

}

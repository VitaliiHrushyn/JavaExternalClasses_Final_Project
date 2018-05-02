package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.util.ResourceBundle;

import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.*;
import static ua.training.repairagency.controller.constants.MessageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.GetUserByLoginService;

public class LoginCommand implements Command {
	
	private String loginMessage;
	private String authMessage;
	
	ResourceBundle regexBundle = ResourceBundle.getBundle(REGEX_BUNDLE_NAME);

	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);		
		HttpSession session = request.getSession();
		
		
		String path = LOGIN_PAGE;
		
		//TODO : use Optional to avoid checking for a null
		if (validateLogin(login)) {
			
			User user = new GetUserByLoginService().execute(login);
			
			if (validateUserPassword(password, user)) {
				path = CommandUtils.getPathFromRole(user.getRole());
				session.setAttribute(USER, user);
			} else {
				authMessage = AUTH_FAIL_MESSAGE;
			}
		}
		
		request.setAttribute(LOGIN_MESSAGE_PARAM, loginMessage);
		request.setAttribute(AUTH_MESSAGE_PARAM, authMessage);
		loginMessage = null;
		authMessage = null;
		return path;
	}

	private boolean validateLogin(String login) {
		if (login == null || login.isEmpty()) {
			loginMessage = LOGIN_EMPTY_MESSAGE;
			return false;
		} else if(!login.matches(regexBundle.getString(LOGIN_REGEX))) {
			loginMessage = LOGIN_INVALID_MESSAGE;
			return false;
		}
		return true;
	}
	
	private boolean validateUserPassword(String password, User user) {
		return user != null && user.getPassword().equals(password);
	}

}

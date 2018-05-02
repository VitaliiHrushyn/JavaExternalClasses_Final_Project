package ua.training.repairagency.controller.commands.common;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Regex;

import java.util.ResourceBundle;

import ua.training.repairagency.controller.constants.AttributeOrParam;
import ua.training.repairagency.controller.constants.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.GetUserByLoginService;

public class LoginCommand implements Command {
	
	private String loginMessage;
	private String authMessage;
	
	ResourceBundle regexBundle = ResourceBundle.getBundle(Regex.BUNDLE_NAME);

	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter(AttributeOrParam.LOGIN);
		String password = request.getParameter(AttributeOrParam.PASSWORD);		
		HttpSession session = request.getSession();
		
		
		String path = URL.LOGIN_PAGE;
		
		//TODO : use Optional to avoid checking for a null
		if (validateLogin(login)) {
			
			User user = new GetUserByLoginService().execute(login);
			
			if (validateUserPassword(password, user)) {
				path = CommandUtils.getPathFromRole(user.getRole());
				session.setAttribute(AttributeOrParam.USER, user);
			} else {
				authMessage = Message.AUTH_FAIL;
			}
		}
		
		request.setAttribute(AttributeOrParam.LOGIN_MESSAGE, loginMessage);
		request.setAttribute(AttributeOrParam.AUTH_MESSAGE, authMessage);
		loginMessage = null;
		authMessage = null;
		return path;
	}

	private boolean validateLogin(String login) {
		if (login == null || login.isEmpty()) {
			loginMessage = Message.LOGIN_EMPTY;
			return false;
		} else if(!login.matches(regexBundle.getString(Regex.LOGIN))) {
			loginMessage = Message.LOGIN_INVALID;
			return false;
		}
		return true;
	}
	
	private boolean validateUserPassword(String password, User user) {
		return user != null && user.getPassword().equals(password);
	}

}

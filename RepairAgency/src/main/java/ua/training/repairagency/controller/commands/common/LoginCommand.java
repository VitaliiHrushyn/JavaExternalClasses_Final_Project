package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.RegEx;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.GetUserByLoginService;

public class LoginCommand implements Command {
	
	private String message;
	private ResourceBundle regexBundle;

	@Override
	public String execute(HttpServletRequest request) {
		
		this.regexBundle = ResourceBundle.getBundle(RegEx.BUNDLE_NAME, CommandUtils.getLocale(request));
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);		
		String path = URL.LOGIN_PAGE;
		
		//TODO : use Optional to avoid checking for a null
		if (validateLogin(login)) {			
			User user = new GetUserByLoginService(login).execute();			
			if (checkUserPassword(user, password)) {
				path = CommandUtils.getPathFromRole(user.getRole());
				request.getSession().setAttribute(USER, user);
			}
		}		
		request.setAttribute(LOGIN_MESSAGE, message);
		return path;
	}

	private boolean validateLogin(String login) {
		if (login == null || login.isEmpty()) {
			message = Message.LOGIN_EMPTY;
			return false;
		} else if(!login.matches(regexBundle.getString(RegEx.LOGIN))) {
			message = Message.LOGIN_INVALID;
			return false;
		}
		return true;
	}
	
	private boolean checkUserPassword(User user, String password) {
		if(user != null && user.getPassword().equals(CommandUtils.doCrypt(password))) {
			return true;
		} else {
			message = Message.AUTH_FAIL;
			return false;
		}
	}

}

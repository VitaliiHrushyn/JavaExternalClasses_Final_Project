package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.utils.UserUtils;

public class LoginCommand extends AbstractCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
						
		if (CommandUtils.checkLoginCredentials(request, errorMessages)) {			
			User user = getAndCheckUserIfExists(request, errorMessages);
			path = CommandUtils.getUserPage(user);
			request.getSession().setAttribute(USER, user);			
		} else {
			path = URL.LOGIN_PAGE;
		}
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return path;
	}

	private User getAndCheckUserIfExists(HttpServletRequest request, List<String> errorMessages) {
		User user = serviceFactory
				.createUserService()
				.getByLogin((request.getParameter(LOGIN)));
		
		if (!checkUserPassword(request, user)) {
			errorMessages.add(messageBundle.getString(Message.AUTH_FAIL));
			return null;
		} 
		else if (!CommandUtils.setUserAsLogged(request, user.getId())) {
			errorMessages.add(messageBundle.getString(Message.USER_ALREADY_LOGGINED));
			return null;
		} else {
			return user;
		}	
	}

	private boolean checkUserPassword(HttpServletRequest request, User user) {
		if (user == null) {
			return false;
		} 
		return user.getPassword().equals(UserUtils.doCrypt(request.getParameter(PASSWORD)));
	}
	
}
 
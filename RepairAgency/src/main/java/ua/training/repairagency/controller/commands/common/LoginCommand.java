package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

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
		
		messages = new ArrayList<>();	
						
		if (CommandUtils.checkLoginCredentials(request, messages)) {			
			User user = getAndCheckUserIfExists(request, messages);
			path = CommandUtils.getUserPage(user);
			request.getSession().setAttribute(USER, user);			
		} else {
			path = URL.LOGIN_PAGE;
		}
		request.setAttribute(MESSAGES, messages);
		return path;
	}

	private User getAndCheckUserIfExists(HttpServletRequest request, List<String> messages) {
		User user = serviceFactory
				.createUserService()
				.getByLogin((request.getParameter(LOGIN)));
		
		if (!checkUserPassword(request, user)) {
			messages.add(Message.AUTH_FAIL);
			return null;
		} 
		else if (!CommandUtils.setUserAsLogged(request, user.getId())) {
			messages.add(Message.USER_ALREADY_LOGGINED);
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
 
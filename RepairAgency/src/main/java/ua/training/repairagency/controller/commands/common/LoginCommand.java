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
			User user = getUserIfExists(request, messages);
			path = CommandUtils.getUserPage(user);
			request.getSession().setAttribute(USER, user);
		} else {
			path = URL.LOGIN_PAGE;
		}
		request.setAttribute(MESSAGES, messages);
		return path;
	}

	private User getUserIfExists(HttpServletRequest request, List<String> messages) {
		User user = serviceFactory
				.createUserService()
				.getByLogin((request.getParameter(LOGIN)));
		
		if (user != null && checkUserPassword(request, user)) {
			return user;
		} else {
			messages.add(Message.AUTH_FAIL);
			return null;
		}		
	}

	private boolean checkUserPassword(HttpServletRequest request, User user) {
		return user.getPassword().equals(UserUtils.doCrypt(request.getParameter(PASSWORD)));
	}

}

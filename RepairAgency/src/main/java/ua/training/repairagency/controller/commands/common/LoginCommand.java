package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.interfaces.*;

public class LoginCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request) {
		
		List<String> messages = new ArrayList<>();	
		String path;
		
		//TODO 
		
		if (CommandUtils.checkLoginCredentials(request, messages)) {			
			User user = getUserIfExists(request, messages);
			path = CommandUtils.getUserPage(user);
			request.getSession().setAttribute(USER, user);
		} else {
			path = URL.LOGIN_PAGE;
		}
		request.setAttribute(LOGIN_MESSAGES, messages);
		return path;
	}

	private User getUserIfExists(HttpServletRequest request, List<String> messages) {
		User user = ServiceFactory.getInstance().createUserService().getByLogin((request.getParameter(LOGIN)));
		if (user != null && user.getPassword().equals(CommandUtils.doCrypt(request.getParameter(PASSWORD)))) {
			return user;
		} else {
			messages.add(Message.AUTH_FAIL);
			return null;
		}		
	}


}

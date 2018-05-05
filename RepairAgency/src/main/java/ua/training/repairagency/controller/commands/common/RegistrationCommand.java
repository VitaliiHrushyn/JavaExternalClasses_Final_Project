package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.interfaces.ServiceFactory;

public class RegistrationCommand implements Command {	
	
	@Override
	public String execute(HttpServletRequest request) {
		
		List<String> messages = new ArrayList<>();
		String path;
		
		if (CommandUtils.checkRegistrationCredentials(request, messages)) {				
			try {
				User user = ServiceFactory.getInstance().getUserService().insert(CommandUtils.createUser(request));				
				request.getSession().setAttribute(USER, user);
				path = CommandUtils.getUserPage(user);
			} catch (NotUniqueFieldValueException e) {
				messages.add(CommandUtils.getFailMessageFromException(e));
				path = URL.REGISTRATION_PAGE;
			} 			
		} else {
			path = URL.REGISTRATION_PAGE;
		}
		request.setAttribute(REGISTRATION_MESSAGES, messages);
		return path;
	}	
	
}

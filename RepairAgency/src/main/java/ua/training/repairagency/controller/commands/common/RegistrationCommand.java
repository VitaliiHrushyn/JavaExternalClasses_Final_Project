package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;

public class RegistrationCommand extends AbstractCommand {	
	
	@Override
	public String execute(HttpServletRequest request) {
		
		messages = new ArrayList<>();
		
		if (CommandUtils.checkRegistrationCredentials(request, messages)) {				
			try {
				User user = serviceFactory
						.createUserService()
						.insert(UserUtils.createUser(request));	
				
				request.getSession().setAttribute(USER, user);
				path = CommandUtils.getUserPage(user);				
			} catch (NotUniqueFieldValueException e) {
				messages.add(CommandUtils.getFailMessageFromException(e));
				path = URL.REGISTRATION_PAGE;
			} 			
		} else {
			path = URL.REGISTRATION_PAGE;
		}
		request.setAttribute(MESSAGES, messages);
		return path;
	}	
	
}

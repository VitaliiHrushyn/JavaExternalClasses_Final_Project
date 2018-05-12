package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.AccessUtils;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;

public class RegistrationCommand extends AbstractCommand {	
	
	private static String path = URL.REGISTRATION;

	public RegistrationCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		
		if (CommandUtils.checkRegistrationCredentials(request, errorMessages)) {				
			try {
				User user = serviceFactory
						.createUserService()
						.insert(UserUtils.createUser(request));	
				
				page = AccessUtils.loginUserAndGetUsePage(request, user);		
			} catch (NotUniqueFieldValueException e) {
				errorMessages.add(messageBundle.getString(CommandUtils.getFailMessageFromException(e)));
				page = URL.REGISTRATION_PAGE;
			} 			
		} else {
			page = URL.REGISTRATION_PAGE;
		}
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return page;
	}	
	
}

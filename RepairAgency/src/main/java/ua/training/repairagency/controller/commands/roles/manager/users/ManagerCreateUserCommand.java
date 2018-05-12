package ua.training.repairagency.controller.commands.roles.manager.users;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;

public class ManagerCreateUserCommand extends AbstractCommand {	
	
	private static String path = URL.MANAGER_CREATE_USER_PATH;

	public ManagerCreateUserCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		infoMessages = new ArrayList<>();
		
		if (CommandUtils.checkRegistrationCredentials(request, errorMessages)) {				
			try {
						serviceFactory
						.createUserService()
						.insert(UserUtils.createUser(request));	
				infoMessages.add(messageBundle.getString(Message.USER_CREAT_SUCCESS));
			} catch (NotUniqueFieldValueException e) {
				errorMessages.add(messageBundle.getString(CommandUtils.getFailMessageFromException(e)));
			} 			
		}
		request.setAttribute(INFO_MESSAGES, infoMessages);
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return URL.MANAGER_CREATE_USER_PAGE;
	}	
	
}

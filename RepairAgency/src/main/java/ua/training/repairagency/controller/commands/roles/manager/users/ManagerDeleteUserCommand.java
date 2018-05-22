package ua.training.repairagency.controller.commands.roles.manager.users;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.ERROR_MESSAGES;
import static ua.training.repairagency.controller.constants.AttributeOrParam.INFO_MESSAGES;
import static ua.training.repairagency.controller.constants.AttributeOrParam.DELETING_USER_ID;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class ManagerDeleteUserCommand extends AbstractCommand {

	private static String path = URL.MANAGER_USER_DELETE_PATH; 

	public ManagerDeleteUserCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		infoMessages = new ArrayList<>();
		
		if (CommandUtils.isRequestContainsParam(request, DELETING_USER_ID)) {	
					serviceFactory
					.createUserService()
					.delete(Integer.valueOf(request.getParameter(DELETING_USER_ID)));
			
			infoMessages.add(messageBundle.getString(Message.DELETE_USER_SUCCESS));
			
			request.setAttribute(ERROR_MESSAGES, errorMessages);
			request.setAttribute(INFO_MESSAGES, infoMessages);
			return URL.MANAGER_USERS_INDEX_PAGE;	
			
		} else {
			return URL.MANAGER_USERS_INDEX_PAGE;
		}
		
		
	}	
	
}

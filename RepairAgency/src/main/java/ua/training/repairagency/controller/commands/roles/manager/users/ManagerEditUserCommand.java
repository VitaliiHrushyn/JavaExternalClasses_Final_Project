package ua.training.repairagency.controller.commands.roles.manager.users;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.ERROR_MESSAGES;
import static ua.training.repairagency.controller.constants.AttributeOrParam.INFO_MESSAGES;
import static ua.training.repairagency.controller.constants.AttributeOrParam.USER_ID;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NAME;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EDITED_USER;



import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class ManagerEditUserCommand extends AbstractCommand {

	private static String path = URL.MANAGER_USER_EDIT_PATH;

	public ManagerEditUserCommand(Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		infoMessages = new ArrayList<>();
		User user = null;
		
		if (CommandUtils.isRequestContainsParam(request, USER_ID)) {
			user = serviceFactory
					.createUserService()
					.getById(Integer.valueOf(request.getParameter(USER_ID)));
		} 
				
		if (user == null) {
			return URL.MANAGER_USERS_INDEX_PAGE;
		}
		
		if (CommandUtils.isRequestContainsParam(request, NAME)
				&& CommandUtils.checkEditingUserCredentials(request, errorMessages)) {
			try {				
				user = serviceFactory
						.createUserService()
						.update(UserUtils.updateUserFeatures(user, request));				
				
				infoMessages.add(messageBundle.getString(Message.UPDATE_USER_SUCCESS));
			} catch (NotUniqueFieldValueException e) {
				errorMessages.add(messageBundle.getString(CommandUtils.getFailMessageFromException(e)));
			}
		}
		request.setAttribute(EDITED_USER, user);
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);
		return URL.MANAGER_EDIT_USER_PAGE;
	}	
	
}

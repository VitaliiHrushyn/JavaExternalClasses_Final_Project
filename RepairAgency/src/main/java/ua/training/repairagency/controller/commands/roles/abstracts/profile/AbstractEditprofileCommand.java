package ua.training.repairagency.controller.commands.roles.abstracts.profile;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.AccessUtils;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public abstract class AbstractEditprofileCommand extends AbstractCommand {	
	
	public AbstractEditprofileCommand(String path, Map<String, Command> commands) {
		super(path, commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		infoMessages = new ArrayList<>();
		
		if (CommandUtils.isRequestContainsParam(request, USER_ID)) {	
			try {
				User user = serviceFactory
						.createUserService()
						.getById(Integer.valueOf(request.getParameter(USER_ID)));
				
				String oldLogin = user.getLogin();
				
				user = serviceFactory
						.createUserService()
						.update(UserUtils.updateUserFeatures(user, request));
				
				String newLogin = user.getLogin();
				
				AccessUtils.changeLoginOfLoggedUser(request, oldLogin, newLogin);
				request.getSession().setAttribute(USER, user);
				infoMessages.add(messageBundle.getString(Message.UPDATE_USER_SUCCESS));
			} catch (NotUniqueFieldValueException e) {
				errorMessages.add(messageBundle.getString(CommandUtils.getFailMessageFromException(e)));
			}
		}
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);
		return getEditprofilePage();	
	}
	
	protected abstract String getEditprofilePage();
}

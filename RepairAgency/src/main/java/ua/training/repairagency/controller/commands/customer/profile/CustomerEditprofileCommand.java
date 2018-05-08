package ua.training.repairagency.controller.commands.customer.profile;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.UserUtils;
import ua.training.repairagency.controller.commands.AbstractCommand;

public class CustomerEditprofileCommand extends AbstractCommand {	
	
	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
		infoMessages = new ArrayList<>();
		
		if (request.getParameter(USER_ID) != null) {	
			try {
				User user = serviceFactory
						.createUserService()
						.getById(Integer.valueOf(request.getParameter(USER_ID)));
				
				user = serviceFactory
						.createUserService()
						.update(UserUtils.updateUser(user, request));
				
				request.getSession().setAttribute(USER, user);
				infoMessages.add(messageBundle.getString(Message.UPDATE_USER_SUCCESS));
				path = URL.CUSTOMER_PROFILE_PAGE; 
			} catch (NotUniqueFieldValueException e) {
				errorMessages.add(messageBundle.getString(CommandUtils.getFailMessageFromException(e)));
				path = URL.CUSTOMER_EDITPROFILE_PAGE;
			}
		} else {
			path = URL.CUSTOMER_EDITPROFILE_PAGE;
		}
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		request.setAttribute(INFO_MESSAGES, infoMessages);
		return path;
	}

}

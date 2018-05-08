package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.constants.Message;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.utils.AccessUtils;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.utils.UserUtils;

public class LoginCommand extends AbstractCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
		
		messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, CommandUtils.getLocale(request));
		errorMessages = new ArrayList<>();
						
		if (CommandUtils.checkLoginCredentials(request, errorMessages)) {			
			User user = fetchAndCheckUserIfExists(request, errorMessages);
			page = AccessUtils.loginUserAndGetUsePage(request, user);
		} else {
			page = URL.LOGIN_PAGE;
		}
		request.setAttribute(ERROR_MESSAGES, errorMessages);
		return page;
	}

	private User fetchAndCheckUserIfExists(HttpServletRequest request, List<String> errorMessages) {
		User user = serviceFactory
				.createUserService()
				.getByLogin((request.getParameter(LOGIN)));
		
		if (!checkUserPassword(request, user)) {
			errorMessages.add(messageBundle.getString(Message.AUTH_FAIL));
			return null;
		} else {
			return user;
		}	
	}

	private boolean checkUserPassword(HttpServletRequest request, User user) {
		if (user == null) {
			loggerAuth.info("Login process FAIL: DB has no such login=" + request.getParameter(LOGIN) + ";");
			return false;
		}
		else if (user.getPassword().equals(UserUtils.doCrypt(request.getParameter(PASSWORD)))) {
			loggerAuth.info("Login process success: " + user + ";");
			return true;
		} else {
			loggerAuth.info("Login process FAIL: wrong password=" + request.getParameter(PASSWORD) + " for " + user + ";");
			return false;
		}
	}
	
}
 
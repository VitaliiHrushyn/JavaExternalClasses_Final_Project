package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.constants.*;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.InsertUserService;

public class RegistrationCommand implements Command {
	
	private String message;
	private ResourceBundle regexBundle = ResourceBundle.getBundle(RegEx.BUNDLE_NAME);

	@Override
	public String execute(HttpServletRequest request) {
		
		HttpSession session = request.getSession();		
		User user = null;		
		String path = URL.LOGIN_PAGE;
		
		if (checkCredentials(request)) {				
			try {
				user = new InsertUserService(CommandUtils.createUser(request)).execute();				
				path = CommandUtils.getPathFromRole(user.getRole());
			} catch (NotUniqueFieldValueException e) {
				message = CommandUtils.getFailMessageFromException(e);
			} 			
		} else {
			message = Message.REGISTRATION_EMPTY;
		}
		session.setAttribute(USER, user);	
		request.setAttribute(REGISTRATION_MESSAGE, message);
		return path;
	}
	
	//TODO : use Optional to avoid checking for a null
	private boolean checkCredentials(HttpServletRequest request) {
		
		String login = request.getParameter(REGISTRATION_LOGIN);
		String password = (request.getParameter(REGISTRATION_PASSWORD));
		String confirmpassword = request.getParameter(CONFIRM_PASSWORD);
	//	String role = request.getParameter(ROLE);
		String name = request.getParameter(NAME);
		String email = request.getParameter(EMAIL);
		String phone = request.getParameter(PHONE);
		
		boolean check = true;
		
		if (!login.matches(regexBundle.getString(RegEx.LOGIN))) {
			CommandUtils.concatMessage(message, Message.LOGIN_INVALID);
			check = false;
		}
		if (!password.matches(regexBundle.getString(RegEx.PASSWORD))) {
			CommandUtils.concatMessage(message, Message.PASSWORD_INVALID);
			check = false;
		}
		if (!confirmpassword.equals(password)) {
			CommandUtils.concatMessage(message, Message.CONFIRMPASSWORD_INVALID);
			check = false;
		}
//		if (!role.matches(RegEx.LOGIN)) {
//			message = message.concat(Message.LOGIN_INVALID);
//			check = false;
//		}
		if (!name.matches(regexBundle.getString(RegEx.NAME))) {
			CommandUtils.concatMessage(message, Message.NAME_INVALID);
			check = false;
		}
		if (!email.matches(regexBundle.getString(RegEx.EMAIL))) {
			CommandUtils.concatMessage(message, Message.EMAIL_INVALID);
			check = false;
		}
		if (!phone.matches(regexBundle.getString(RegEx.PHONE))){
			CommandUtils.concatMessage(message, Message.PHONE_INVALID);
			check = false;
		}

		return check;
	}
	
}

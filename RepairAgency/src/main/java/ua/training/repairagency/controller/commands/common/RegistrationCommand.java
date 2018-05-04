package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.constants.*;
import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.interfaces.ServiceFactory;

public class RegistrationCommand implements Command {
	
	private List<String> messages;
	private ResourceBundle regexBundle;
	
	@Override
	public String execute(HttpServletRequest request) {
		
		this.messages = new ArrayList<>();
		this.regexBundle = ResourceBundle.getBundle(RegEx.BUNDLE_NAME, CommandUtils.getLocale(request));
		HttpSession session = request.getSession();		
		User user = null;		
		String path = URL.LOGIN_PAGE;
		
		if (checkCredentials(request)) {				
			try {
				user = ServiceFactory.getInstance().getInsertUserService().insert(CommandUtils.createUser(request));				
				path = CommandUtils.getPathFromRole(user.getRole());
			} catch (NotUniqueFieldValueException e) {
				messages.add(CommandUtils.getFailMessageFromException(e));
			} 			
		} 

		session.setAttribute(USER, user);	
		request.setAttribute(REGISTRATION_MESSAGES, messages);
		return path;
	}

	//TODO : use Optional to avoid checking for a null
	private boolean checkCredentials(HttpServletRequest request) {
		
		String login = request.getParameter(REGISTRATION_LOGIN);
		String password = (request.getParameter(REGISTRATION_PASSWORD));
		String confirmpassword = request.getParameter(CONFIRM_PASSWORD);
		String name = request.getParameter(NAME);
		String email = request.getParameter(EMAIL);
		String phone = request.getParameter(PHONE);
		
		/*
		 * when reload registration page sends null to all parameters,
		 * to avoid exception is enough to check first param to null
		 * and return from method
		 */
		if (login == null) {
			return false;
		}
		boolean check = true;
				
		if (!login.matches(regexBundle.getString(RegEx.LOGIN))) {
			messages.add(Message.LOGIN_INVALID);
			messages.add(Message.COMMA);
			check = false;
		}
		if (!password.matches(regexBundle.getString(RegEx.PASSWORD))) {
			messages.add(Message.PASSWORD_INVALID);
			messages.add(Message.COMMA);
			check = false;
		}
		if (!confirmpassword.equals(password)) {
			messages.add(Message.CONFIRMPASSWORD_INVALID);
			messages.add(Message.COMMA);
			check = false;
		}
		if (!name.matches(regexBundle.getString(RegEx.NAME))) {
			messages.add(Message.NAME_INVALID);
			messages.add(Message.COMMA);
			check = false;
		}
		if (!email.matches(regexBundle.getString(RegEx.EMAIL))) {
			messages.add(Message.EMAIL_INVALID);
			messages.add(Message.COMMA);
			check = false;
		}
		if (!phone.matches(regexBundle.getString(RegEx.PHONE))){
			messages.add(Message.PHONE_INVALID);
			check = false;
		}

		return check;
	}
	
}

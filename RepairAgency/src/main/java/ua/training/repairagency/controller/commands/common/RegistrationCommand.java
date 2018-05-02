package ua.training.repairagency.controller.commands.common;

import static ua.training.repairagency.controller.constants.PathConstants.LOGIN_PAGE;
import static ua.training.repairagency.controller.constants.AttributeAndParamConstants.*;
import static ua.training.repairagency.controller.constants.MessageConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.CreateUserService;

public class RegistrationCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request) {
		
		String login = request.getParameter(REGISTRATION_LOGIN);
		String password = request.getParameter(REGISTRATION_PASSWORD);
		String confirmpassword = request.getParameter(CONFIRM_PASSWORD);
				
		HttpSession session = request.getSession();
		
		User user = null;
		String message = null;
		String path = LOGIN_PAGE;
		
		if (checkLoginPasswordConfirm(login, password, confirmpassword)) {				
			try {
				user = new CreateUserService().execute(request);				
				path = CommandUtils.getPathFromRole(user.getRole());
			} catch (NotUniqueFieldValueException e) {
				message = CommandUtils.getFailMessageFromException(e);
			} 			
		} else {
			message = REGISTRATION_EMPTY_MESSAGE;
		}
		session.setAttribute(USER, user);	
		request.setAttribute(REGISTRATION_MESSAGE_PARAM, message);
		return path;
	}
	
	//TODO : use Optional to avoid checking for a null
	private boolean checkLoginPasswordConfirm(String login, String password, String confirmpassword) {
		return (login != null && password != null && confirmpassword != null) && 
				(!login.isEmpty() && !password.isEmpty()) && !confirmpassword.isEmpty() &&
				password.equals(confirmpassword);
	}

}
